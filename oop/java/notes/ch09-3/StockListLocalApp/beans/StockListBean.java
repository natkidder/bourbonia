package beans;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class StockListBean implements SessionBean  {
	// The public business methods, which must be coded in the remote interface also
	
	public String getStock(String ticker) throws FinderException  {
		try  {
			LocalStockHome stockHome = getStockHome();
			LocalStock stock = stockHome.findByPrimaryKey(ticker);
			return stock.getName();
		} catch (FinderException fe) {
			throw fe;
		} catch (Exception ex)  {
			throw new RuntimeException(ex.getMessage());
		}
	}

	public void addStock(String ticker, String name) throws CreateException  {
		try  {
			LocalStockHome stockHome = getStockHome();
			stockHome.create(ticker, name);
		} catch (CreateException ce)  {
			throw ce;
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	public void updateStock(String ticker, String name) throws FinderException  {
		try  {
			LocalStockHome stockHome = getStockHome();
			LocalStock stock = stockHome.findByPrimaryKey(ticker);
			stock.setName(name);
		} catch (FinderException fe)  {
			throw fe;
		} catch (Exception ex)  {
			throw new RuntimeException(ex.getMessage());
		}
	}

	public void deleteStock(String ticker) throws NamingException  {
		try  {
			LocalStockHome stockHome = getStockHome();
			LocalStock stock = stockHome.findByPrimaryKey(ticker);
			stock.remove();
		} catch (NamingException ne)  {
			throw ne;
		} catch (Exception ex)  {
			throw new RuntimeException(ex.getMessage());
		}
	}

	private LocalStockHome getStockHome() throws NamingException  {
		// Get the initial context
		InitialContext initial = new InitialContext();

		// Get the object reference
		Object objref = initial.lookup("java:comp/env/ejb/beans.Stock");
		LocalStockHome home = (LocalStockHome) objref;
//		Object objref = initial.lookup("ejb/beans.Stock");
//		LocalStockHome home = (StockHome) PortableRemoteObject.narrow(objref, LocalStockHome.class);
		
		return home;
	}

	// Standard ejb methods
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void ejbRemove()  {}
	public void ejbCreate()  {}
	public void setSessionContext(SessionContext context)  {}
}
