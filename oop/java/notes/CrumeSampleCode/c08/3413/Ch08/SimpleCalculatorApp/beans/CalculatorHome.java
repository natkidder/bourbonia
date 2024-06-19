package beans;

import java.rmi.RemoteException;
import javax.ejb.EJBHome;
import javax.ejb.CreateException;

public interface CalculatorHome extends EJBHome {
  // the create method for the Calculator bean.
  public Calculator create()
    throws CreateException, RemoteException;
}