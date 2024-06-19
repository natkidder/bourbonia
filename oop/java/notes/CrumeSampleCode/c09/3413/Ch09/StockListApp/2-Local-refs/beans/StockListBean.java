package beans;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
  
  public void addStock(String ticker, String name)
    throws CreateException {
    try {
      LocalStockHome stockHome = getStockHome();
      stockHome.create(ticker, name);
    }
    catch (CreateException ce) {
      throw ce;
    }
    catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
  }
    
  public void updateStock(String ticker, String name)
   throws FinderException {
    try {
      LocalStockHome stockHome = getStockHome();
      LocalStock stock = stockHome.findByPrimaryKey(ticker);
      stock.setName(name);
    }
    catch (FinderException fe) {
      throw fe;
    }
    catch (Exception ex) {
      throw new RuntimeException(ex.getMessage());
    }
   }
   
  public void deleteStock(String ticker)
    throws FinderException {
    try {
      LocalStockHome stockHome = getStockHome();
      LocalStock stock = stockHome.findByPrimaryKey(ticker);
      stock.remove();
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
  public void ejbActivate() {}
  public void ejbPassivate() {}
  public void ejbRemove() {}
  public void ejbCreate() {}
  public void setSessionContext(SessionContext context) { }
}