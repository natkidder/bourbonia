// LB 141  Book 2, Chapter 3
import java.text.NumberFormat;
import java.util.Scanner;

public class NbrFormat  {

	public static Scanner scIn = new Scanner(System.in);

	public static void main(String[] args)  {

		System.out.print("Enter a decimal number: ");
		double dX = scIn.nextDouble();
		NumberFormat nfNbr = NumberFormat.getNumberInstance();
//		nfNbr.setMininumFractionDigits(3);
		nfNbr.setMaximumFractionDigits(3);
		System.out.println("3-decimal format: " + nfNbr.format(dX));

		NumberFormat nfCurrency = NumberFormat.getCurrencyInstance();
		System.out.println("Currency format: " + nfCurrency.format(dX));

		System.out.print("Enter a decimal number whose absolute value is between zero and one: ");
		double dPct = scIn.nextDouble();
		NumberFormat nfPct = NumberFormat.getPercentInstance();
		nfPct.setMaximumFractionDigits(1);
		System.out.println("Percent format: " + nfPct.format(dPct));
	}
}
