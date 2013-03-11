/*******************************************************************************
 * This file is protected by Copyright. 
 * Please refer to the COPYRIGHT file distributed with this source distribution.
 *
 * This file is part of REDHAWK IDE.
 *
 * All rights reserved.  This program and the accompanying materials are made available under 
 * the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package gov.redhawk.ide.sandbox.console.py;

import gov.redhawk.ide.debug.ScaDebugPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.Launch;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.statushandlers.StatusManager;
import org.python.pydev.core.IInterpreterInfo;
import org.python.pydev.core.IInterpreterManager;
import org.python.pydev.core.IPythonNature;
import org.python.pydev.core.Tuple4;
import org.python.pydev.debug.newconsole.PydevConsole;
import org.python.pydev.debug.newconsole.PydevConsoleFactory;
import org.python.pydev.debug.newconsole.PydevConsoleInterpreter;
import org.python.pydev.debug.newconsole.env.IProcessFactory;
import org.python.pydev.plugin.PydevPlugin;

/**
 * 
 */
public class RHLocalConsoleFactory implements IConsoleFactory {

	/**
	 * @since 1.1
	 */
	public static final String DONE_INIT_COMMENT = "#DONE SETUP";

	/**
	 * {@inheritDoc}
	 */
	public void openConsole() {
		final PydevConsoleFactory factory = new PydevConsoleFactory();
		try {
			final IProcessFactory processFactory = new IProcessFactory();

			final IInterpreterManager interpreterManager = PydevPlugin.getPythonInterpreterManager();
			final IInterpreterInfo[] interpreters = interpreterManager.getInterpreterInfos();
			if (interpreters.length == 0) {
				StatusManager.getManager().handle(new Status(IStatus.ERROR, RHLocalConsolePlugin.PLUGIN_ID, Messages.RHLocalConsoleFactory_PY_ERROR, null),
				        StatusManager.LOG | StatusManager.SHOW);
			}
			final IInterpreterInfo interpreterInfo = interpreters[0];
			final Collection<String> pythonPath = interpreterInfo.getPythonPath();
			final IPythonNature nature = null;
			final List<IPythonNature> natures = new ArrayList<IPythonNature>();
			final Tuple4<Launch, Process, Integer, IInterpreterInfo> tuple = processFactory.createLaunch(interpreterManager, interpreterInfo, pythonPath,
			        nature, natures);

			final PydevConsoleInterpreter interpreter = PydevConsoleFactory.createPydevInterpreter(tuple.o1, tuple.o2, tuple.o3, tuple.o4,
			        processFactory.getNaturesUsed());
			final String additionalInitialComands = NLS.bind(Messages.RHLocalConsoleFactory_PY_INIT, ScaDebugPlugin.getInstance().getSandbox());
			final PydevConsole console = factory.createConsole(interpreter, additionalInitialComands);
			// TODO Clear the console after initial commands executed
			//			console.addListener(new IScriptConsoleListener() {
			//				private boolean clear = false;
			//
			//				public void userRequest(final String arg0, final ScriptConsolePrompt arg1) {
			//					if (RHLocalConsoleFactory.DONE_INIT_COMMENT.equals(arg0)) {
			//						this.clear = true;
			//					}
			//				}
			//
			//				public void interpreterResponse(final InterpreterResponse arg0, final ScriptConsolePrompt arg1) {
			//					if (this.clear) {
			//						console.removeListener(this);
			//						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			//
			//							public void run() {
			//								console.clearConsole();
			//							}
			//
			//						});
			//					}
			//				}
			//			});

		} catch (final Exception e) {
			StatusManager.getManager().handle(new Status(IStatus.ERROR, RHLocalConsolePlugin.PLUGIN_ID, Messages.RHLocalConsoleFactory_PY_ERROR, e),
			        StatusManager.LOG | StatusManager.SHOW);
		}

	}

}
