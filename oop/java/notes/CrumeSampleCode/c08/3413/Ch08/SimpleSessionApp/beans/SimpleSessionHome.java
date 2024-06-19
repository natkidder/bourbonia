package beans;

import java.rmi.RemoteException;
import javax.ejb.EJBHome;
import javax.ejb.CreateException;

public interface SimpleSessionHome extends EJBHome {
  // The create method for the SimpleSession bean
  public SimpleSession create()
    throws CreateException, RemoteException;

}