/**
 * MortgageIndexLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package NET.webserviceX.www;

public class MortgageIndexLocator extends org.apache.axis.client.Service implements NET.webserviceX.www.MortgageIndex {

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

    public MortgageIndexLocator() {
    }


    public MortgageIndexLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MortgageIndexLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MortgageIndexSoap12
    private java.lang.String MortgageIndexSoap12_address = "http://www.webservicex.net/MortgageIndex.asmx";

    public java.lang.String getMortgageIndexSoap12Address() {
        return MortgageIndexSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MortgageIndexSoap12WSDDServiceName = "MortgageIndexSoap12";

    public java.lang.String getMortgageIndexSoap12WSDDServiceName() {
        return MortgageIndexSoap12WSDDServiceName;
    }

    public void setMortgageIndexSoap12WSDDServiceName(java.lang.String name) {
        MortgageIndexSoap12WSDDServiceName = name;
    }

    public NET.webserviceX.www.MortgageIndexSoap getMortgageIndexSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MortgageIndexSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMortgageIndexSoap12(endpoint);
    }

    public NET.webserviceX.www.MortgageIndexSoap getMortgageIndexSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            NET.webserviceX.www.MortgageIndexSoap12Stub _stub = new NET.webserviceX.www.MortgageIndexSoap12Stub(portAddress, this);
            _stub.setPortName(getMortgageIndexSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMortgageIndexSoap12EndpointAddress(java.lang.String address) {
        MortgageIndexSoap12_address = address;
    }


    // Use to get a proxy class for MortgageIndexSoap
    private java.lang.String MortgageIndexSoap_address = "http://www.webservicex.net/MortgageIndex.asmx";

    public java.lang.String getMortgageIndexSoapAddress() {
        return MortgageIndexSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MortgageIndexSoapWSDDServiceName = "MortgageIndexSoap";

    public java.lang.String getMortgageIndexSoapWSDDServiceName() {
        return MortgageIndexSoapWSDDServiceName;
    }

    public void setMortgageIndexSoapWSDDServiceName(java.lang.String name) {
        MortgageIndexSoapWSDDServiceName = name;
    }

    public NET.webserviceX.www.MortgageIndexSoap getMortgageIndexSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MortgageIndexSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMortgageIndexSoap(endpoint);
    }

    public NET.webserviceX.www.MortgageIndexSoap getMortgageIndexSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            NET.webserviceX.www.MortgageIndexSoapStub _stub = new NET.webserviceX.www.MortgageIndexSoapStub(portAddress, this);
            _stub.setPortName(getMortgageIndexSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMortgageIndexSoapEndpointAddress(java.lang.String address) {
        MortgageIndexSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (NET.webserviceX.www.MortgageIndexSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                NET.webserviceX.www.MortgageIndexSoap12Stub _stub = new NET.webserviceX.www.MortgageIndexSoap12Stub(new java.net.URL(MortgageIndexSoap12_address), this);
                _stub.setPortName(getMortgageIndexSoap12WSDDServiceName());
                return _stub;
            }
            if (NET.webserviceX.www.MortgageIndexSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                NET.webserviceX.www.MortgageIndexSoapStub _stub = new NET.webserviceX.www.MortgageIndexSoapStub(new java.net.URL(MortgageIndexSoap_address), this);
                _stub.setPortName(getMortgageIndexSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MortgageIndexSoap12".equals(inputPortName)) {
            return getMortgageIndexSoap12();
        }
        else if ("MortgageIndexSoap".equals(inputPortName)) {
            return getMortgageIndexSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.webserviceX.NET/", "MortgageIndex");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "MortgageIndexSoap12"));
            ports.add(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "MortgageIndexSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MortgageIndexSoap12".equals(portName)) {
            setMortgageIndexSoap12EndpointAddress(address);
        }
        else 
if ("MortgageIndexSoap".equals(portName)) {
            setMortgageIndexSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
