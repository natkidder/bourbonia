// LB 179, book 2, chapter 5
import java.util.Scanner;

public class GetABet3   {

	private static Scanner scIn = new Scanner(System.in);

	public static void main(String[] args)   {
		final int iBank = 1000;
		int iBet;
		boolean bValidBet;
		prtln("You may bet between 1 and " + iBank);

		try {
			do  {
				prt("Enter your integer bet: ");
				iBet = scIn.nextInt();
				bValidBet = true;
				if ( iBet <= 0 || iBet > 1000)  {
					bValidBet = false;
					prtln(iBet + " is outside your credit limit ");
				}
			} while ( ! bValidBet );

			prtln("Your money's good here.");
		}
		catch (java.util.InputMismatchException ime)  {
			prtln(ime.toString() + ": Please enter a whole number");
		}
	}

	protected static void prt(String s) { System.out.print(s); }
	protected static void prtln(String s) { System.out.println(s);  }
}
