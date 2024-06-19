// LB 177, book 2, chapter 5
import java.util.*;

public class GetABet   {

	private static Scanner scIn = new Scanner(System.in);

	public static void main(String[] args)   {
		int iBank = 1000;   // assume user has $1K to bet with
		int iBet;

		System.out.println("You can bet a whole number between 1 and " + iBank);

        try   {
			do    {
				System.out.print("Enter your bet: ");
				iBet = scIn.nextInt();
			} while ( iBet <= 0  || iBet > iBank );

			prtln("Your money's good here.");
		}
		catch (InputMismatchException ime)  {
			prtln("Please enter a whole number");
			prtln("ime.getMessage(): " + ime.getMessage());
			prtln("ime.toString(): " + ime.toString());

		}
	}
	private static void prtln(String s)  {
		System.out.println(s);
	}
}
