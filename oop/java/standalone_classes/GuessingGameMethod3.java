// LB 220, Book 2, Chapter 7
import java.util.Scanner;

public class GuessingGameMethod3   {

	static Scanner sc = new Scanner(System.in);

	private static void prt(String s)    {  System.out.print(s);  }
	private static void prtln(String s)  {  System.out.println(s);  }

	public static void main(String args[])  {
		prt("Let's play a guessing game\n");

		do   {
			playARound(1, getRandomNumber(7, 12) );

		} while ( askForAnotherRound("Try again? ") );

		prtln("\nThank you for playing");
	}

	protected static void playARound(int iMin, int iMax)   {

		boolean bValidInput;
		int iNbr, iGuess;
		String sAnswer;

		// pick a random number
		iNbr = getRandomNumber(iMin, iMax);

		// get the guess
		prtln("\nI'm thinking of a random number between " + iMin + " and " + iMax + " ");
		prt("What do you think it is? ");
		iGuess = getGuess(iMin, iMax);

		// check the guess
		if (iGuess == iNbr)
			prtln("You're right!");
		else
			prtln("You're wrong.  The number was " + iNbr);
	}

	protected static int getRandomNumber(int iMin, int iMax)  {
		return (int)(Math.random() * iMax) + iMin;
	}

	private static int getGuess(int iMin, int iMax)  {

		while (true)  {
			int iGuess = sc.nextInt();
			if ( iGuess < iMin || iGuess > iMax )
				prt("Guess MUST be between " + iMin + " and " + iMax + ".  Try again: ");
			else
				return iGuess;
		}
	}

	private static boolean askForAnotherRound(String sPrompt)  {
		while (true)  {
			String sAnswer;
			prt("\n" + sPrompt + " (Y/N) ");
			sAnswer = sc.next();
			sAnswer = sAnswer.substring(0,1);
			if ( sAnswer.equalsIgnoreCase("y") )
				return true;
			else
				return false;

		}
	}

}
