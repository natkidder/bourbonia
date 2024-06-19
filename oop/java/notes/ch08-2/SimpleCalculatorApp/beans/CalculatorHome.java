package beans;

import java.rmi.RemoteException;
import javax.ejb.EJBHome;
import javax.ejb.CreateException;

public interface CalculatorHome extends EJBHome  {
	// since it's a home session bean, it signs a create method
	public Calculator create() throws CreateException, RemoteException;
}
