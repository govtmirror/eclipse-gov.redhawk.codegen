package gov.redhawk.ide.codegen.frontend.ui.wizard;

import gov.redhawk.eclipsecorba.idl.Definition;
import gov.redhawk.eclipsecorba.idl.IdlInterfaceDcl;
import gov.redhawk.eclipsecorba.library.IdlLibrary;
import gov.redhawk.eclipsecorba.library.RepositoryModule;
import gov.redhawk.ide.codegen.ICodeGeneratorDescriptor;
import gov.redhawk.ide.codegen.ImplementationSettings;
import gov.redhawk.ide.codegen.frontend.FeiDevice;
import gov.redhawk.ide.codegen.frontend.FrontendPackage;
import gov.redhawk.ide.codegen.ui.ICodegenWizardPage;
import gov.redhawk.ui.RedhawkUiActivator;

import java.util.ArrayList;
import java.util.List;

import mil.jpeojtrs.sca.spd.Implementation;
import mil.jpeojtrs.sca.spd.SoftPkg;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class FrontEndTunerOptionsWizardPage extends WizardPage implements ICodegenWizardPage {

	private ImplementationSettings implSettings;
	private FeiDevice feiDevice;
	private Composite client;
	DataBindingContext ctx;
	String[] propertyTypes;
	private Composite parent;

	public FrontEndTunerOptionsWizardPage(FeiDevice feiDevice) {
		super("");
		this.feiDevice = feiDevice;
		populatePropertyTypes();

		// Initialize the model object
		this.feiDevice.setDigitalInputTypeForTx(propertyTypes[0]);
		this.feiDevice.setDigitalInputType(propertyTypes[0]);
		this.feiDevice.setDigitalOutputType(propertyTypes[0]);
	}

	@Override
	public void createControl(Composite parent) {
		this.setTitle("Front End Interface Tuner Options");
		this.setDescription("Select the input and output types for this Front End Interfaces Tuner Device");
		this.parent = parent;
		client = new Composite(parent, SWT.NULL);
		ctx = new DataBindingContext();

		createUIElements(client);

		this.setControl(client);
	}

	private void populatePropertyTypes() {
		IdlLibrary idlLibrary = RedhawkUiActivator.getDefault().getIdlLibraryService().getLibrary();
		RepositoryModule bulkioIdl;
		List<String> bulkioTypes = new ArrayList<String>();

		// Grab array of available BULKIO types
		for (Definition def : idlLibrary.getDefinitions()) {
			if ("BULKIO".equals(def.getName())) {
				bulkioIdl = (RepositoryModule) def;
				
				// We don't want these to show up in any combos
				List <String> removedTypes = new ArrayList<String> (); 
				removedTypes.add("IDL:BULKIO/ProvidesPortStatisticsProvider:1.0");
				removedTypes.add("IDL:BULKIO/UsesPortStatisticsProvider:1.0");
				removedTypes.add("IDL:BULKIO/dataFile:1.0");
				removedTypes.add("IDL:BULKIO/updateSRI:1.0");
				removedTypes.add("IDL:BULKIO/dataXML:1.0");
				
				for (Definition bulkioDef : bulkioIdl.getDefinitions()) {
					if (bulkioDef instanceof IdlInterfaceDcl) {
						if(removedTypes.contains(bulkioDef.getRepId())) {
							continue;
						}
						bulkioTypes.add(bulkioDef.getRepId());
					}
				}
			}
		}

		// Convert to String[] for convenience in passing to SWT widgets
		propertyTypes = new String[bulkioTypes.size()];
		for (int i = 0; i < propertyTypes.length; i++) {
			propertyTypes[i] = bulkioTypes.get(i);
		}
	}

	private void createUIElements(Composite client) {
		client.setLayout(new GridLayout(1, false));

		if (!feiDevice.isTxTuner()) {
			createReceiverGroup(client);
		} else if (!feiDevice.isRxTuner()) {
			createTransmitterGroup(client);
		} else {
			createReceiverGroup(client);
			createTransmitterGroup(client);
		}
	}

	// Create Receiver Group and all sub-methods
	private void createReceiverGroup(Composite client) {
		Group receiverGroup = new Group(client, SWT.SHADOW_ETCHED_IN);
		receiverGroup.setText("Receiver Properties");
		receiverGroup.setLayout(new GridLayout(2, false));
		receiverGroup.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());

		createInputControl(receiverGroup);
		createOutputControl(receiverGroup);
	}

	private void createInputControl(Group parent) {
		Composite inputContainer = new Composite(parent, SWT.None);
		inputContainer.setLayout(new GridLayout(1, false));
		inputContainer.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());

		Button analogInputButton = new Button(inputContainer, SWT.RADIO);
		analogInputButton.setText("Analog Input (default)");
		analogInputButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true, false, 2, 1));
		createAnalogIn(inputContainer);
		UpdateValueStrategy uvs = booleanConverter();
		ctx.bindValue(WidgetProperties.selection().observe(analogInputButton),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__HAS_DIGITAL_INPUT), uvs, uvs);

		Button digitalInputButton = new Button(inputContainer, SWT.RADIO);
		digitalInputButton.setText("Digital Input");
		digitalInputButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true, false, 2, 1));
		createDigitalIn(inputContainer);
		ctx.bindValue(WidgetProperties.selection().observe(digitalInputButton),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__HAS_DIGITAL_INPUT));
		
		digitalInputButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				feiDevice.setHasDigitalOutput(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
	}

	private Composite createAnalogIn(Composite parent) {
		Composite analogIn = new Composite(parent, SWT.SHADOW_NONE);
		analogIn.setLayout(new GridLayout(2, false));
		analogIn.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).indent(-35, 0).align(SWT.CENTER, SWT.CENTER).create());

		Label numAnalogLabel = new Label(analogIn, SWT.None);
		numAnalogLabel.setText("Number of Analog input ports: ");

		Spinner numAnalogSpinner = new Spinner(analogIn, SWT.BORDER);
		numAnalogSpinner.setMinimum(1);
		UpdateValueStrategy uvs = booleanConverter();
		ctx.bindValue(WidgetProperties.selection().observe(numAnalogSpinner),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__NUMBER_OF_ANALOG_INPUTS));
		ctx.bindValue(WidgetProperties.enabled().observe(numAnalogSpinner),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__HAS_DIGITAL_INPUT), uvs, uvs);
		return analogIn;
	}

	private Composite createDigitalIn(Composite parent) {
		Composite digitalIn = new Composite(parent, SWT.SHADOW_NONE);
		digitalIn.setLayout(new GridLayout(2, false));
		digitalIn.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).indent(30, 0).align(SWT.CENTER, SWT.CENTER).create());

		Label digitalInputTypeLabel = new Label(digitalIn, SWT.None);
		digitalInputTypeLabel.setText("Digital Input Type: ");

		Combo digitalInputCombo = new Combo(digitalIn, SWT.READ_ONLY);
		digitalInputCombo.setItems(propertyTypes);
		ctx.bindValue(WidgetProperties.selection().observe(digitalInputCombo),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__DIGITAL_INPUT_TYPE));
		ctx.bindValue(WidgetProperties.enabled().observe(digitalInputCombo),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__HAS_DIGITAL_INPUT));
		return digitalIn;
	}

	private void createOutputControl(Group parent) {
		Composite outputContainer = new Composite(parent, SWT.None);
		outputContainer.setLayout(new GridLayout(1, false));
		outputContainer.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());

		Button analogOutputButton = new Button(outputContainer, SWT.RADIO);
		analogOutputButton.setText("Analog Output");
		analogOutputButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true, false, 2, 1));
		UpdateValueStrategy uvs = booleanConverter();
		ctx.bindValue(WidgetProperties.enabled().observe(analogOutputButton),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__HAS_DIGITAL_INPUT),uvs,uvs);
		ctx.bindValue(WidgetProperties.selection().observe(analogOutputButton),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__HAS_DIGITAL_OUTPUT),uvs,uvs);

		Button digitalOutputButton = new Button(outputContainer, SWT.RADIO);
		digitalOutputButton.setText("Digital Output (default)");
		digitalOutputButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true, false, 2, 1));
		createDigitalOut(outputContainer);
		ctx.bindValue(WidgetProperties.selection().observe(digitalOutputButton),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__HAS_DIGITAL_OUTPUT));
	}

	private Composite createDigitalOut(Composite parent) {
		Composite digitalOut = new Composite(parent, SWT.SHADOW_NONE);
		digitalOut.setLayout(new GridLayout(2, false));
		digitalOut.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).indent(30, 0).align(SWT.CENTER, SWT.CENTER).create());

		Label digitalOutputTypeLabel = new Label(digitalOut, SWT.None);
		digitalOutputTypeLabel.setText("Digital Output Type: ");

		Combo digitalOutputCombo = new Combo(digitalOut, SWT.READ_ONLY);
		digitalOutputCombo.setItems(propertyTypes);
		ctx.bindValue(WidgetProperties.selection().observe(digitalOutputCombo),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__DIGITAL_OUTPUT_TYPE));
		ctx.bindValue(WidgetProperties.enabled().observe(digitalOutputCombo),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__HAS_DIGITAL_OUTPUT));

		Button multiOutCheck = new Button(digitalOut, SWT.CHECK);
		multiOutCheck.setText("Multi-out");
		ctx.bindValue(WidgetProperties.selection().observe(multiOutCheck),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__MULTI_OUT));
		ctx.bindValue(WidgetProperties.enabled().observe(multiOutCheck),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__HAS_DIGITAL_OUTPUT));
		return digitalOut;
	} //End Receiver Group

	//Create Transmitter Group and all sub-methods
	private void createTransmitterGroup(Composite client) {
		Group transmitterGroup = new Group(client, SWT.SHADOW_ETCHED_IN);
		transmitterGroup.setText("Transmitter Properties");
		transmitterGroup.setLayout(new GridLayout(4, false));
		transmitterGroup.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());

		Label numDigitalInLabel = new Label(transmitterGroup, SWT.None);
		numDigitalInLabel.setText("Number of Digital input ports: ");

		Spinner numDigitalSpinner = new Spinner(transmitterGroup, SWT.BORDER);
		numDigitalSpinner.setMinimum(1);
		ctx.bindValue(WidgetProperties.selection().observe(numDigitalSpinner),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__NUMBER_OF_DIGITAL_INPUTS_FOR_TX));

		Label digitalInputTypeLabel = new Label(transmitterGroup, SWT.None);
		digitalInputTypeLabel.setText("Digital Input Type: ");
		digitalInputTypeLabel.setLayoutData(GridDataFactory.fillDefaults().indent(50, 0).align(SWT.CENTER, SWT.CENTER).create());

		Combo digitalInputCombo = new Combo(transmitterGroup, SWT.READ_ONLY);
		digitalInputCombo.setItems(propertyTypes);
		ctx.bindValue(WidgetProperties.selection().observe(digitalInputCombo),
			EMFObservables.observeValue(this.feiDevice, FrontendPackage.Literals.FEI_DEVICE__DIGITAL_INPUT_TYPE_FOR_TX));
	} //End Transmitter Group

	private UpdateValueStrategy booleanConverter() {
		UpdateValueStrategy converter = new UpdateValueStrategy();
		converter.setConverter(new IConverter() {

			@Override
			public Object getToType() {
				return Boolean.class;
			}

			@Override
			public Object getFromType() {
				return Boolean.class;
			}

			@Override
			public Object convert(Object fromObject) {
				return !((Boolean) fromObject).booleanValue();
			}
		});
		return converter;
	}

	@Override
	public void configure(SoftPkg softpkg, Implementation impl, ICodeGeneratorDescriptor desc, ImplementationSettings implSettings, String componentType) {
		this.implSettings = implSettings;
	}

	@Override
	public ImplementationSettings getSettings() {
		return this.implSettings;
	}

	@Override
	public boolean canFinish() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanFlipToNextPage(boolean canFlip) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setCanFinish(boolean canFinish) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			client.dispose();
			createControl(parent);
			parent.layout(true, true);
		}
	}

}
