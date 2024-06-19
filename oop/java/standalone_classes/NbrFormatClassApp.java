// LB 141  Book 2, Chapter 3
import java.text.NumberFormat;
import java.util.Scanner;

public class NbrFormatClassApp  {

	static Scanner scIn = new Scanner(System.in);
	static NumberFormat nfCurrency = NumberFormat.getCurrencyInstance();

	public static void main(String[] args)  {
		double dAllowance;
		double dCostOfPaintBallGun;
		System.out.print("Enter Allowance: ");
		dAllowance = scIn.nextDouble();
		System.out.print("Enter Cost of Paint Ball Gun: ");
		dCostOfPaintBallGun = scIn.nextDouble();
		printMyAllowance(dAllowance);
		printCostOfPaintBallGun(dCostOfPaintBallGun);
	}

	private static void printMyAllowance(double dMyAllowance)  {
//		double dMyAllowance = 5.00;
		nfCurrency = NumberFormat.getCurrencyInstance();
		System.out.println("My allowance: " + nfCurrency.format(dMyAllowance));
	}

	private static void printCostOfPaintBallGun(double dCostOfPaintBallGun)  {
//		double dCostOfPaintBallGun = 69.95;
		nfCurrency = NumberFormat.getCurrencyInstance();
		System.out.println("Cost of Paint Ball Gun: " + nfCurrency.format(dCostOfPaintBallGun));
	}
}
