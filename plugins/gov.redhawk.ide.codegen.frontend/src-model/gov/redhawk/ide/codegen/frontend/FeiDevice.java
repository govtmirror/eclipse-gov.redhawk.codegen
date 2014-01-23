/**
 */
package gov.redhawk.ide.codegen.frontend;

import gov.redhawk.model.sca.ScaStructProperty;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fei Device</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isIsAntenna <em>Is Antenna</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isIngestsGPS <em>Ingests GPS</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isOutputsGPS <em>Outputs GPS</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isIsRxTuner <em>Is Rx Tuner</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isHasAnalogInput <em>Has Analog Input</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#getNumberOfAnalogInputs <em>Number Of Analog Inputs</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isHasDigitalInput <em>Has Digital Input</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#getDigitalInputType <em>Digital Input Type</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isIsMultiOut <em>Is Multi Out</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#getDigitalOutputType <em>Digital Output Type</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isIsTxTuner <em>Is Tx Tuner</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#getNumberOfDigitalInputsForTx <em>Number Of Digital Inputs For Tx</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#getDigitalInputTypeForTx <em>Digital Input Type For Tx</em>}</li>
 *   <li>{@link gov.redhawk.ide.codegen.frontend.FeiDevice#getTunerStatusStruct <em>Tuner Status Struct</em>}</li>
 * </ul>
 * </p>
 *
 * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice()
 * @model
 * @generated
 */
public interface FeiDevice extends EObject
{
  /**
   * Returns the value of the '<em><b>Is Antenna</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Antenna</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Antenna</em>' attribute.
   * @see #setIsAntenna(boolean)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_IsAntenna()
   * @model unique="false"
   * @generated
   */
  boolean isIsAntenna();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isIsAntenna <em>Is Antenna</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Antenna</em>' attribute.
   * @see #isIsAntenna()
   * @generated
   */
  void setIsAntenna(boolean value);

  /**
   * Returns the value of the '<em><b>Ingests GPS</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ingests GPS</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ingests GPS</em>' attribute.
   * @see #setIngestsGPS(boolean)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_IngestsGPS()
   * @model unique="false"
   * @generated
   */
  boolean isIngestsGPS();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isIngestsGPS <em>Ingests GPS</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ingests GPS</em>' attribute.
   * @see #isIngestsGPS()
   * @generated
   */
  void setIngestsGPS(boolean value);

  /**
   * Returns the value of the '<em><b>Outputs GPS</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outputs GPS</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outputs GPS</em>' attribute.
   * @see #setOutputsGPS(boolean)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_OutputsGPS()
   * @model unique="false"
   * @generated
   */
  boolean isOutputsGPS();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isOutputsGPS <em>Outputs GPS</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Outputs GPS</em>' attribute.
   * @see #isOutputsGPS()
   * @generated
   */
  void setOutputsGPS(boolean value);

  /**
   * Returns the value of the '<em><b>Is Rx Tuner</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Rx Tuner</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Rx Tuner</em>' attribute.
   * @see #setIsRxTuner(boolean)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_IsRxTuner()
   * @model unique="false"
   * @generated
   */
  boolean isIsRxTuner();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isIsRxTuner <em>Is Rx Tuner</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Rx Tuner</em>' attribute.
   * @see #isIsRxTuner()
   * @generated
   */
  void setIsRxTuner(boolean value);

  /**
   * Returns the value of the '<em><b>Has Analog Input</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Analog Input</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Analog Input</em>' attribute.
   * @see #setHasAnalogInput(boolean)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_HasAnalogInput()
   * @model unique="false"
   * @generated
   */
  boolean isHasAnalogInput();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isHasAnalogInput <em>Has Analog Input</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Analog Input</em>' attribute.
   * @see #isHasAnalogInput()
   * @generated
   */
  void setHasAnalogInput(boolean value);

  /**
   * Returns the value of the '<em><b>Number Of Analog Inputs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number Of Analog Inputs</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number Of Analog Inputs</em>' attribute.
   * @see #setNumberOfAnalogInputs(int)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_NumberOfAnalogInputs()
   * @model unique="false"
   * @generated
   */
  int getNumberOfAnalogInputs();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#getNumberOfAnalogInputs <em>Number Of Analog Inputs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number Of Analog Inputs</em>' attribute.
   * @see #getNumberOfAnalogInputs()
   * @generated
   */
  void setNumberOfAnalogInputs(int value);

  /**
   * Returns the value of the '<em><b>Has Digital Input</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Digital Input</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Digital Input</em>' attribute.
   * @see #setHasDigitalInput(boolean)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_HasDigitalInput()
   * @model unique="false"
   * @generated
   */
  boolean isHasDigitalInput();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isHasDigitalInput <em>Has Digital Input</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Digital Input</em>' attribute.
   * @see #isHasDigitalInput()
   * @generated
   */
  void setHasDigitalInput(boolean value);

  /**
   * Returns the value of the '<em><b>Digital Input Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Digital Input Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Digital Input Type</em>' attribute.
   * @see #setDigitalInputType(String)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_DigitalInputType()
   * @model unique="false"
   * @generated
   */
  String getDigitalInputType();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#getDigitalInputType <em>Digital Input Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Digital Input Type</em>' attribute.
   * @see #getDigitalInputType()
   * @generated
   */
  void setDigitalInputType(String value);

  /**
   * Returns the value of the '<em><b>Is Multi Out</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Multi Out</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Multi Out</em>' attribute.
   * @see #setIsMultiOut(boolean)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_IsMultiOut()
   * @model unique="false"
   * @generated
   */
  boolean isIsMultiOut();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isIsMultiOut <em>Is Multi Out</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Multi Out</em>' attribute.
   * @see #isIsMultiOut()
   * @generated
   */
  void setIsMultiOut(boolean value);

  /**
   * Returns the value of the '<em><b>Digital Output Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Digital Output Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Digital Output Type</em>' attribute.
   * @see #setDigitalOutputType(String)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_DigitalOutputType()
   * @model unique="false"
   * @generated
   */
  String getDigitalOutputType();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#getDigitalOutputType <em>Digital Output Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Digital Output Type</em>' attribute.
   * @see #getDigitalOutputType()
   * @generated
   */
  void setDigitalOutputType(String value);

  /**
   * Returns the value of the '<em><b>Is Tx Tuner</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Tx Tuner</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Tx Tuner</em>' attribute.
   * @see #setIsTxTuner(boolean)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_IsTxTuner()
   * @model unique="false"
   * @generated
   */
  boolean isIsTxTuner();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#isIsTxTuner <em>Is Tx Tuner</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Tx Tuner</em>' attribute.
   * @see #isIsTxTuner()
   * @generated
   */
  void setIsTxTuner(boolean value);

  /**
   * Returns the value of the '<em><b>Number Of Digital Inputs For Tx</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number Of Digital Inputs For Tx</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number Of Digital Inputs For Tx</em>' attribute.
   * @see #setNumberOfDigitalInputsForTx(int)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_NumberOfDigitalInputsForTx()
   * @model unique="false"
   * @generated
   */
  int getNumberOfDigitalInputsForTx();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#getNumberOfDigitalInputsForTx <em>Number Of Digital Inputs For Tx</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number Of Digital Inputs For Tx</em>' attribute.
   * @see #getNumberOfDigitalInputsForTx()
   * @generated
   */
  void setNumberOfDigitalInputsForTx(int value);

  /**
   * Returns the value of the '<em><b>Digital Input Type For Tx</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Digital Input Type For Tx</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Digital Input Type For Tx</em>' attribute.
   * @see #setDigitalInputTypeForTx(String)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_DigitalInputTypeForTx()
   * @model unique="false"
   * @generated
   */
  String getDigitalInputTypeForTx();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#getDigitalInputTypeForTx <em>Digital Input Type For Tx</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Digital Input Type For Tx</em>' attribute.
   * @see #getDigitalInputTypeForTx()
   * @generated
   */
  void setDigitalInputTypeForTx(String value);

  /**
   * Returns the value of the '<em><b>Tuner Status Struct</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tuner Status Struct</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tuner Status Struct</em>' attribute.
   * @see #setTunerStatusStruct(ScaStructProperty)
   * @see gov.redhawk.ide.codegen.frontend.FrontendPackage#getFeiDevice_TunerStatusStruct()
   * @model unique="false" dataType="gov.redhawk.ide.codegen.frontend.TunerStatusStruct"
   * @generated
   */
  ScaStructProperty getTunerStatusStruct();

  /**
   * Sets the value of the '{@link gov.redhawk.ide.codegen.frontend.FeiDevice#getTunerStatusStruct <em>Tuner Status Struct</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tuner Status Struct</em>' attribute.
   * @see #getTunerStatusStruct()
   * @generated
   */
  void setTunerStatusStruct(ScaStructProperty value);

} // FeiDevice