package beans;

import java.rmi.RemoteException;
import javax.ejb.FinderException;
import javax.ejb.EJBObject;

// general imports
import java.util.*;

public interface StockList extends EJBObject {
  // the public business methods on the Stock List bean
  public String[] getSizeStocks(int siz)
    throws FinderException, RemoteException;
  public String[] getAllStocks()
    throws FinderException, RemoteException;
  public String getStock(String ticker)
    throws FinderException, RemoteException;
}