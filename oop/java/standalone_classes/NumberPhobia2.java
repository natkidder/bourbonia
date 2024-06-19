// LB 173, book 2, chapter 5
import java.util.Scanner;

public class NumberPhobia2   {

	static private Scanner scIn = new Scanner(System.in);

	public static void main(String[] args)   {
		int iNbr = 2;
		String sInput = "Y";

		// contrast with NumberPhobia
		while (sInput.matches("^[Yy]") )   {
			System.out.println(iNbr + "  ");
			System.out.print("Do you wish to keep counting? (Y or N) ");

			sInput = scIn.next();
			System.out.println("sInput = '" + sInput + "'"); ////

			iNbr += 2;
		}
		System.out.println("\nWhew!  That was close.");
	}
}
