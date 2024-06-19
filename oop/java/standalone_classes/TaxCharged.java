// LB 274, book 3, chapter 2
import utilities.*;
import java.util.Scanner;

public class TaxCharged   {
	public static void main(String args[])  {
		Invoice invTotal = new Invoice( 100 );
		Prt.prtln("Amount owed: " + invTotal.getTax());
	}
}

/*
class Invoice  {
	private static double fTaxRate = 7.5;  // must be a blue state
	private double fSalesTotal = 100;

	public double getTax()  {
		return fSalesTotal * (fTaxRate / 100);
	}
}
*/
