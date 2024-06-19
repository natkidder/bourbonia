// LB 274, book 3, chapter 3
// illustrates using static variables inside and instance context, which compiles fine

public class Invoice  {

	private final static double fTaxRate = 0.075;
	private double fBaseInvoice;
	private double fSalesTotal;

	public Invoice( double fBaseInvoice )  {
		this.fBaseInvoice = fBaseInvoice;
	}

	public double getTax()  {

        System.out.println("In public Invoice.getTax");
		return fBaseInvoice * fTaxRate;
	}
}
