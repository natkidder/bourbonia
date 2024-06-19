package beans;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBObject;
import javax.ejb.FinderException;

public interface StockList extends EJBObject  {
	// The public business methods in the Stocklist bean
	
	public String getStock(String ticker) throws FinderException, RemoteException;
	
	public void addStock(String ticker, String name) throws CreateException, RemoteException;
	
	public void updateStock(String ticker, String name) throws FinderException, RemoteException;
	
	public void deleteStock(String ticker) throws FinderException, RemoteException;
}
