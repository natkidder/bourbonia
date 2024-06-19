
/**
 * ConverterCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

package wtp;

/**
 *  ConverterCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class ConverterCallbackHandler{



	protected Object clientData;

	/**
	 * User can pass in any object that needs to be accessed once the NonBlocking
	 * Web service call is finished and appropriate method of this CallBack is called.
	 * @param clientData Object mechanism by which the user can pass in user data
	 * that will be available at the time this callback is called.
	 */
	public ConverterCallbackHandler(Object clientData){
		this.clientData = clientData;
	}

	/**
	 * Please use this constructor if you don't want to set any clientData
	 */
	public ConverterCallbackHandler(){
		this.clientData = null;
	}

	/**
	 * Get the client data
	 */

	public Object getClientData() {
		return clientData;
	}


	/**
	 * auto generated Axis2 call back method for farenheitToCelsius method
	 * override this method for handling normal response from farenheitToCelsius operation
	 */
	public void receiveResultfarenheitToCelsius(wtp.ConverterStub.FarenheitToCelsiusResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler
	 * override this method for handling error response from farenheitToCelsius operation
	 */
	public void receiveErrorfarenheitToCelsius(java.lang.Exception e) {
	}

	/**
	 * auto generated Axis2 call back method for celsiusToFarenheit method
	 * override this method for handling normal response from celsiusToFarenheit operation
	 */
	public void receiveResultcelsiusToFarenheit(wtp.ConverterStub.CelsiusToFarenheitResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler
	 * override this method for handling error response from celsiusToFarenheit operation
	 */
	public void receiveErrorcelsiusToFarenheit(java.lang.Exception e) {
	}

/* ================== Centimeters and Inches ========================= */
	
	/**
	 * auto generated Axis2 call back method for farenheitToCelsius method
	 * override this method for handling normal response from farenheitToCelsius operation
	 */
	public void receiveResultinchToCm(wtp.ConverterInchStub.InchToCmResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler
	 * override this method for handling error response from farenheitToCelsius operation
	 */
	public void receiveErrorinchToCm(java.lang.Exception e) {
	}

	/**
	 * auto generated Axis2 call back method for celsiusToFarenheit method
	 * override this method for handling normal response from celsiusToFarenheit operation
	 */
	public void receiveResultcmToInch(wtp.ConverterInchStub.CmToInchResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler
	 * override this method for handling error response from celsiusToFarenheit operation
	 */
	public void receiveErrorcmToInch(java.lang.Exception e) {
	}	

}
