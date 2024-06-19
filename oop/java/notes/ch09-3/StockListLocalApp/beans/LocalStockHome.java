package beans;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface LocalStockHome extends EJBLocalHome  {
	// The create method for the Stock bean
	public LocalStock create(String ticker, String name) throws CreateException;

	// The find by primary key method for the Stock bean
	public LocalStock findByPrimaryKey(String ticker) throws FinderException;
}
