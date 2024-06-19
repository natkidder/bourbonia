// LB 172, book 2, chapter 5
import java.util.Scanner;

public class NumberPhobia   {
	static Scanner scIn = new Scanner(System.in);

	public static void main(String[] args)  {
		int iNbr = 2;
		String sInput;

		// contrast with NumberPhobia2
		while (true)   {
			System.out.println(iNbr + "  ");
			System.out.print("Do you want to keep counting (Y/N) ? ");
			sInput = scIn.nextLine();   // or just scIn.next()
			if (sInput.equalsIgnoreCase("N"))
				break;
			iNbr += 2;
		}
		System.out.println("\nWhew!  That was close.\n");
	}
}
