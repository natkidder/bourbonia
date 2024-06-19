/**
 * MortgageIndex.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package NET.webserviceX.www;

public interface MortgageIndex extends javax.xml.rpc.Service {

/**
 * <p><br>This Web service Provides monthly ,weekly and Historical
 * Mortgage Indexes.<br>There are many possible ARM indexes. Each one
 * has distinct market characteristics and fluctuates differently.<br>
 * <UL><LI>Constant Maturity Treasury (CMT) <br><LI>Treasury Bill (T-Bill)
 * <br><LI>12-Month Treasury Average (MTA) <LI>Cost of Deposits Index
 * (CODI) <LI>11th District Cost of Funds Index (COFI) <LI>Cost of Savings
 * Index (COSI) <LI>London Inter Bank Offering Rates (LIBOR) <LI>Certificates
 * of Deposit (CD) Indexes <LI>Prime Rate <LI>Fannie Mae's Required Net
 * Yield (RNY) </UL></p>
 */
    public java.lang.String getMortgageIndexSoap12Address();

    public NET.webserviceX.www.MortgageIndexSoap getMortgageIndexSoap12() throws javax.xml.rpc.ServiceException;

    public NET.webserviceX.www.MortgageIndexSoap getMortgageIndexSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getMortgageIndexSoapAddress();

    public NET.webserviceX.www.MortgageIndexSoap getMortgageIndexSoap() throws javax.xml.rpc.ServiceException;

    public NET.webserviceX.www.MortgageIndexSoap getMortgageIndexSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
