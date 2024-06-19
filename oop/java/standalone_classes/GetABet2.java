// LB 178, book 2, chapter 5
import java.util.*;

public class GetABet2   {

	private static Scanner scIn = new Scanner(System.in);

	public static void main(String[] args)   {
		final int iBank = 1000;
		int iBet;
		prtln("You may bet between 1 and " + iBank);

        try  {
			do   {
				prt("Enter your integer bet: ");
				iBet = scIn.nextInt();
				if ( iBet <= 0 || iBet > 1000)
					System.out.println("Your bet is outside your credit limit");
			} while ( iBet <= 0 || iBet > 1000);

			prtln("Your money's good here.");
		}
		catch (InputMismatchException ime)   {
			prtln("Please enter a whole number");
		}
	}

	private static void prt(String s) {  System.out.print(s); }
	private static void prtln(String s) { System.out.println(s);  }
}
