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
package gov.redhawk.ide.codegen.jet.java;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class JavaJetGeneratorPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "gov.redhawk.ide.codegen.jet.java";

	// The shared instance
	private static JavaJetGeneratorPlugin plugin;

	/**
	 * The constructor.
	 */
	public JavaJetGeneratorPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		JavaJetGeneratorPlugin.plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		JavaJetGeneratorPlugin.plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static JavaJetGeneratorPlugin getDefault() {
		return JavaJetGeneratorPlugin.plugin;
	}

	public static String getPluginId() {
		return JavaJetGeneratorPlugin.getDefault().getBundle().getSymbolicName();
	}

	/**
	 * Logging functionality
	 * 
	 * @param msg
	 * @param e
	 * @since 2.1
	 */
	public static final void logError(final String msg, final Throwable e) {
		JavaJetGeneratorPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, JavaJetGeneratorPlugin.PLUGIN_ID, msg, e));
	}

	/**
	 * @since 3.0
	 */
	public static final void logWarning(final String msg, final Throwable e) {
		JavaJetGeneratorPlugin.getDefault().getLog().log(new Status(IStatus.WARNING, JavaJetGeneratorPlugin.PLUGIN_ID, msg, e));
	}
}
