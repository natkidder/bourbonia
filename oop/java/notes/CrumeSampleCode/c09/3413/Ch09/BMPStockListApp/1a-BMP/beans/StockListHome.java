package beans;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface StockListHome extends EJBHome {
  // the create method for the Stock List bean.
  public StockList create()
    throws CreateException, RemoteException;
}