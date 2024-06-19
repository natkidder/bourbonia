package org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service;

public class TerminalLocationProxy implements org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocation {
  private String _endpoint = null;
  private org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocation terminalLocation = null;
  
  public TerminalLocationProxy() {
    _initTerminalLocationProxy();
  }
  
  public TerminalLocationProxy(String endpoint) {
    _endpoint = endpoint;
    _initTerminalLocationProxy();
  }
  
  private void _initTerminalLocationProxy() {
    try {
      terminalLocation = (new org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocationServiceLocator()).getTerminalLocation();
      if (terminalLocation != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)terminalLocation)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)terminalLocation)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (terminalLocation != null)
      ((javax.xml.rpc.Stub)terminalLocation)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocation getTerminalLocation() {
    if (terminalLocation == null)
      _initTerminalLocationProxy();
    return terminalLocation;
  }
  
  public org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationInfo getLocation(org.apache.axis.types.URI requester, org.apache.axis.types.URI address, int requestedAccuracy, int acceptableAccuracy, org.csapi.www.schema.parlayx.common.v2_1.TimeMetric maximumAge, org.csapi.www.schema.parlayx.common.v2_1.TimeMetric responseTime, org.csapi.www.schema.parlayx.terminal_location.v2_2.DelayTolerance tolerance) throws java.rmi.RemoteException, org.csapi.www.schema.parlayx.common.v2_1.PolicyException, org.csapi.www.schema.parlayx.common.v2_1.ServiceException{
    if (terminalLocation == null)
      _initTerminalLocationProxy();
    return terminalLocation.getLocation(requester, address, requestedAccuracy, acceptableAccuracy, maximumAge, responseTime, tolerance);
  }
  
  public int getTerminalDistance(org.apache.axis.types.URI requester, org.apache.axis.types.URI address, float latitude, float longitude) throws java.rmi.RemoteException, org.csapi.www.schema.parlayx.common.v2_1.PolicyException, org.csapi.www.schema.parlayx.common.v2_1.ServiceException{
    if (terminalLocation == null)
      _initTerminalLocationProxy();
    return terminalLocation.getTerminalDistance(requester, address, latitude, longitude);
  }
  
  public org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationData[] getLocationForGroup(org.apache.axis.types.URI requester, org.apache.axis.types.URI[] addresses, int requestedAccuracy, int acceptableAccuracy, org.csapi.www.schema.parlayx.common.v2_1.TimeMetric maximumAge, org.csapi.www.schema.parlayx.common.v2_1.TimeMetric responseTime, org.csapi.www.schema.parlayx.terminal_location.v2_2.DelayTolerance tolerance) throws java.rmi.RemoteException, org.csapi.www.schema.parlayx.common.v2_1.PolicyException, org.csapi.www.schema.parlayx.common.v2_1.ServiceException{
    if (terminalLocation == null)
      _initTerminalLocationProxy();
    return terminalLocation.getLocationForGroup(requester, addresses, requestedAccuracy, acceptableAccuracy, maximumAge, responseTime, tolerance);
  }
  
  
}