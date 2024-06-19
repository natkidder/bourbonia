package NET.webserviceX.www;

public class MortgageIndexSoapProxy implements NET.webserviceX.www.MortgageIndexSoap {
  private String _endpoint = null;
  private NET.webserviceX.www.MortgageIndexSoap mortgageIndexSoap = null;
  
  public MortgageIndexSoapProxy() {
    _initMortgageIndexSoapProxy();
  }
  
  public MortgageIndexSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initMortgageIndexSoapProxy();
  }
  
  private void _initMortgageIndexSoapProxy() {
    try {
      mortgageIndexSoap = (new NET.webserviceX.www.MortgageIndexLocator()).getMortgageIndexSoap();
      if (mortgageIndexSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mortgageIndexSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mortgageIndexSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mortgageIndexSoap != null)
      ((javax.xml.rpc.Stub)mortgageIndexSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public NET.webserviceX.www.MortgageIndexSoap getMortgageIndexSoap() {
    if (mortgageIndexSoap == null)
      _initMortgageIndexSoapProxy();
    return mortgageIndexSoap;
  }
  
  public NET.webserviceX.www.MonthlyIndex getCurrentMortgageIndexMonthly() throws java.rmi.RemoteException{
    if (mortgageIndexSoap == null)
      _initMortgageIndexSoapProxy();
    return mortgageIndexSoap.getCurrentMortgageIndexMonthly();
  }
  
  public NET.webserviceX.www.WeeklyIndex getCurrentMortgageIndexByWeekly() throws java.rmi.RemoteException{
    if (mortgageIndexSoap == null)
      _initMortgageIndexSoapProxy();
    return mortgageIndexSoap.getCurrentMortgageIndexByWeekly();
  }
  
  public NET.webserviceX.www.MonthlyIndex getMortgageIndexByMonth(int month, int year) throws java.rmi.RemoteException{
    if (mortgageIndexSoap == null)
      _initMortgageIndexSoapProxy();
    return mortgageIndexSoap.getMortgageIndexByMonth(month, year);
  }
  
  public NET.webserviceX.www.WeeklyIndex getMortgageIndexByWeek(int day, int month, int year) throws java.rmi.RemoteException{
    if (mortgageIndexSoap == null)
      _initMortgageIndexSoapProxy();
    return mortgageIndexSoap.getMortgageIndexByWeek(day, month, year);
  }
  
  
}