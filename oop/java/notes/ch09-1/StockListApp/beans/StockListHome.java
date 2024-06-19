package beans;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface StockListHome extends EJBHome  {
	// The create method for the StockList bean
	public StockList create() throws CreateException, RemoteException;
}
