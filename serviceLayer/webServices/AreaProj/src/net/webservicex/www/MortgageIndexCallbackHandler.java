
/**
 * MortgageIndexCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package net.webservicex.www;

    /**
     *  MortgageIndexCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class MortgageIndexCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public MortgageIndexCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public MortgageIndexCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for GetCurrentMortgageIndexByWeekly method
            * override this method for handling normal response from GetCurrentMortgageIndexByWeekly operation
            */
           public void receiveResultGetCurrentMortgageIndexByWeekly(
                    net.webservicex.www.MortgageIndexStub.GetCurrentMortgageIndexByWeeklyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from GetCurrentMortgageIndexByWeekly operation
           */
            public void receiveErrorGetCurrentMortgageIndexByWeekly(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for GetMortgageIndexByMonth method
            * override this method for handling normal response from GetMortgageIndexByMonth operation
            */
           public void receiveResultGetMortgageIndexByMonth(
                    net.webservicex.www.MortgageIndexStub.GetMortgageIndexByMonthResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from GetMortgageIndexByMonth operation
           */
            public void receiveErrorGetMortgageIndexByMonth(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for GetCurrentMortgageIndexMonthly method
            * override this method for handling normal response from GetCurrentMortgageIndexMonthly operation
            */
           public void receiveResultGetCurrentMortgageIndexMonthly(
                    net.webservicex.www.MortgageIndexStub.GetCurrentMortgageIndexMonthlyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from GetCurrentMortgageIndexMonthly operation
           */
            public void receiveErrorGetCurrentMortgageIndexMonthly(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for GetMortgageIndexByWeek method
            * override this method for handling normal response from GetMortgageIndexByWeek operation
            */
           public void receiveResultGetMortgageIndexByWeek(
                    net.webservicex.www.MortgageIndexStub.GetMortgageIndexByWeekResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from GetMortgageIndexByWeek operation
           */
            public void receiveErrorGetMortgageIndexByWeek(java.lang.Exception e) {
            }
                


    }
    