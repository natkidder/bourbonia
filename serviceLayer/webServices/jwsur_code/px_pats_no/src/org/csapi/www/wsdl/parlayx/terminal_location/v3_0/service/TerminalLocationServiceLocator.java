/**
 * TerminalLocationServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service;

public class TerminalLocationServiceLocator extends org.apache.axis.client.Service implements org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocationService {

    public TerminalLocationServiceLocator() {
    }


    public TerminalLocationServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TerminalLocationServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TerminalLocation
    private java.lang.String TerminalLocation_address = "http://px.pats.no/px/services/TerminalLocation";

    public java.lang.String getTerminalLocationAddress() {
        return TerminalLocation_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TerminalLocationWSDDServiceName = "TerminalLocation";

    public java.lang.String getTerminalLocationWSDDServiceName() {
        return TerminalLocationWSDDServiceName;
    }

    public void setTerminalLocationWSDDServiceName(java.lang.String name) {
        TerminalLocationWSDDServiceName = name;
    }

    public org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocation getTerminalLocation() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TerminalLocation_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTerminalLocation(endpoint);
    }

    public org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocation getTerminalLocation(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocationSoapBindingStub _stub = new org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocationSoapBindingStub(portAddress, this);
            _stub.setPortName(getTerminalLocationWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTerminalLocationEndpointAddress(java.lang.String address) {
        TerminalLocation_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocation.class.isAssignableFrom(serviceEndpointInterface)) {
                org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocationSoapBindingStub _stub = new org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocationSoapBindingStub(new java.net.URL(TerminalLocation_address), this);
                _stub.setPortName(getTerminalLocationWSDDServiceName());
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
        if ("TerminalLocation".equals(inputPortName)) {
            return getTerminalLocation();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.csapi.org/wsdl/parlayx/terminal_location/v3_0/service", "TerminalLocationService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.csapi.org/wsdl/parlayx/terminal_location/v3_0/service", "TerminalLocation"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TerminalLocation".equals(portName)) {
            setTerminalLocationEndpointAddress(address);
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
