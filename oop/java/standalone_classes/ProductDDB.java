// LB 297, book 3, chapter 4
import java.io.*;

public class ProductDDB   {

	public static Product getProduct(String sCode)  throws ProductDataException   {

		try  {
			Product p;
			p = new Product();
			return p;
		}
		catch (ProductDataException ioe)   {
			throw new ProductDataException("An IO error occurred.");
		}
	}
}

class Product {

	public String ProductCode;

	public Product() throws ProductDataException  {
		this.ProductCode = "xxx";
	}
	public String getProductCode()  {
		return this.ProductCode;
	}
}

/* class ProductDataException extends IOException {
	private String explanation;
	public ProductDataException(String s)  {
		this.explanation = s;
	}
	public String getExplanation()  {
		return this.explanation;
	}
}
*/
