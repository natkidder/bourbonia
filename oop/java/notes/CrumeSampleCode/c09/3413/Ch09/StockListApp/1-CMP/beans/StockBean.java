package beans;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class StockBean implements EntityBean {

  // keeps the reference to the context
  private EntityContext _context;

  // the abstract access methods for persistent fields
  public abstract String getTickerSymbol();
  public abstract void setTickerSymbol(String ticker);
  
  public abstract String getName();
  public abstract void setName(String name);
  

  // standard entity bean methods

  public String ejbCreate(String ticker, String name)
    throws CreateException {

    setTickerSymbol(ticker);
    setName(name);
    return null;
  }
         
  public void ejbPostCreate(String ticker, String name)
    throws CreateException { }

  public void setEntityContext(EntityContext ctx) {
      _context = ctx;
  }
    
  public void unsetEntityContext() {
      _context = null;
  }
    
  public void ejbRemove() { }
  public void ejbLoad() { }
  public void ejbStore() { }
  public void ejbPassivate() { }
  public void ejbActivate() { }
}