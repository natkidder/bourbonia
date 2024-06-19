// works with ProductDDB.java

public class RunProductDDB  {

	public static void main(String args[])   {
		try {
			Product p = ProductDDB.getProduct("Dove");
			System.out.println(p.ProductCode);
		}
		catch (ProductDataException pde)  {
			System.out.println(pde.toString());
		}
	}
}
