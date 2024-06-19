package beans;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class SimpleSessionBean implements SessionBean {  
  // The public business method. This must be coded in the
  // remote interface also.
  public String getEchoString(String clientString) {
    return clientString + " - from session bean";
  }

  // Standard ejb methods
  public void ejbActivate() {}
  public void ejbPassivate() {}
  public void ejbRemove() {}
  public void ejbCreate() {}
  public void setSessionContext(SessionContext context) { }
}