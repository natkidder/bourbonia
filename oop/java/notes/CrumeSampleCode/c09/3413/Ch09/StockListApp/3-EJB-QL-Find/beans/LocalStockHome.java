package beans;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

// general imports
import java.util.*;

public interface LocalStockHome extends EJBLocalHome {
  // the create method for the Stock bean
  public LocalStock create(String ticker, String name)
    throws CreateException;
  
  // the find by primary key method for the Stock bean
  public LocalStock findByPrimaryKey(String ticker)
    throws FinderException;
  
  // the find all method for the Stock bean
  public Collection findAllStocks()
    throws FinderException;
  
  // the find by size method for the Stock bean
  public Collection findSizeStocks(int siz)
    throws FinderException;
}