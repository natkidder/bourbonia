package beans;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface Calculator extends EJBObject  {
	// since it's a bean interface, it signs methods for the bean itself
	public void clearIt() throws RemoteException;
	public void calculate(String operation, int value) throws RemoteException;
	public int getValue() throws RemoteException;
}
