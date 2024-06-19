package beans;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface SimpleSession extends EJBObject {
  // The public business method on the SimpleSession bean
  public String getEchoString(String clientString)
    throws RemoteException;
}