package beans;

import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

// general imports
import java.util.*;

public class StockListBean implements SessionBean {
  
  // the public business methods. these must be coded in the 
  // remote interface also. 
  
  public String getStock(String ticker) throws FinderException {
    try {
      LocalStockHome stockHome = getStockHome();
      LocalStock stock = stockHome.findByPrimaryKey(ticker);
      return stock.getName();
    }
    catch (FinderException fe) {
      throw fe;
    }
    catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }
  
  public String[] getAllStocks() throws FinderException {
    try {
      LocalStockHome stockHome = getStockHome();
      Collection stockColl = stockHome.findAllStocks();
      String[] stocks = new String[stockColl.size()];
      int j = 0;
      Iterator i = stockColl.iterator();
      while (i.hasNext()) {
        LocalStock stock = (LocalStock) i.next();
        stocks[j++] = stock.getTickerSymbol();
      }
      
      return stocks;
    }
    catch (FinderException fe) {
      throw fe;
    }
    catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }
  
  public String[] getSizeStocks(int siz) throws FinderException {
    try {
      LocalStockHome stockHome = getStockHome();
      Collection stockColl = stockHome.findSizeStocks(siz);
      String[] stocks = new String[stockColl.size()];
      int j = 0;
      Iterator i = stockColl.iterator();
      while (i.hasNext()) {
        LocalStock stock = (LocalStock) i.next();
        stocks[j++] = stock.getTickerSymbol();
      }
      
      return stocks;
    }
    catch (FinderException fe) {
      throw fe;
    }
    catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }
  
  private LocalStockHome getStockHome() throws NamingException {
    // get the initial context
    InitialContext initial = new InitialContext();
    
    // get the object reference
    Object objref = initial.lookup("java:comp/env/ejb/beans.Stock");
    LocalStockHome home = (LocalStockHome) objref;
    return home;
  }
  

  // standard ejb methods
  public void ejbActivate() { }
  public void ejbPassivate() { }
  public void ejbRemove() { }
  public void ejbCreate() { }
  public void setSessionContext(SessionContext context) { }
}