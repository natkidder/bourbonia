// LB 189, book 2, chapter 5
import java.util.Scanner;

public class GuessingGame  {

	static Scanner scIn = new Scanner(System.in);

	public static void main(String args[])  {

		boolean bKeepPlaying = true;

		prtln("Let's play a guessing game!");

		while (bKeepPlaying)  {
			boolean bValidInput;
			int iNbr, iGuess;
			String sAnswer;

			// Pick a random number;
			iNbr = (int)(Math.random() * 10) + 1;

			// Get the guess
			prtln("\nI'm thinking of a number between 1 and 10.");
			prt("What do you think it is? ");

			do  {
				iGuess = scIn.nextInt();
				bValidInput = true;
				if ( iGuess < 1 || iGuess > 10)  {
					prt("I said between 1 an 10.  Try again: ");
					bValidInput = false;
				}
			} while ( ! bValidInput);

			// Check the guess
			if ( iGuess == iNbr )
				prtln("Your're right!!");
			else
				prtln("You're wrong.  The number was " + iNbr);

			// Play again?
			do  {
				prt("\nPlay again? (Y/N) ");
				sAnswer = scIn.next();
				bValidInput = true;
				if ( sAnswer.matches("^[Yy]") )
					;    // do nothing
				else if ( sAnswer.equalsIgnoreCase("N") )
					bKeepPlaying = false;
				else
					bValidInput = false;
			} while ( ! bValidInput );
		}
		prtln("\nThank you for playing!");
	}

	private static void prt(String s) { System.out.print(s); }
	private static void prtln(String s) { System.out.println(s); }
}
