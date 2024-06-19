package beans;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface Stock extends EJBObject  {
	/* the public business methods on the Stock bean.  These include the accessor methods from the bean 
	   Get the ticker.  Do not allow ticker to be set through the interface because it is the primary key */
	public String getTickerSymbol() throws RemoteException;

	// Get and set the name
	public String getName() throws RemoteException;
	public void setName(String name) throws RemoteException;
}
		
