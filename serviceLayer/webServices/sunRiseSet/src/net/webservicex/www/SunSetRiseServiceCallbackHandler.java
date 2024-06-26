
/**
 * SunSetRiseServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package net.webservicex.www;

    /**
     *  SunSetRiseServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SunSetRiseServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SunSetRiseServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SunSetRiseServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for GetSunSetRiseTime method
            * override this method for handling normal response from GetSunSetRiseTime operation
            */
           public void receiveResultGetSunSetRiseTime(
                    net.webservicex.www.SunSetRiseServiceStub.GetSunSetRiseTimeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from GetSunSetRiseTime operation
           */
            public void receiveErrorGetSunSetRiseTime(java.lang.Exception e) {
            }
                


    }
    