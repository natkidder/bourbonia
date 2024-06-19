package beans;

import java.rmi.RemoteException;
import javax.ejb.EJBHome;
import javax.ejb.CreateException;

public interface SimpleSessionHome extends EJBHome  {
	// SimpleSession factory
	public SimpleSession create() throws CreateException, RemoteException;
}
