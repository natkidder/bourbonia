package beans;

import javax.ejb.EJBLocalObject;

public interface LocalStock extends EJBLocalObject  {
	/* the public business methods on the Stock bean.  These include the accessor methods from the bean 
	   Get the ticker.  Do not allow ticker to be set through the interface because it is the primary key */
	public String getTickerSymbol();

	// Get and set the name
	public String getName() ;
	public void setName(String name) ;
}
		
