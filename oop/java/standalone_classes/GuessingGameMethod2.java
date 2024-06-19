// LB 211, Book 2, Chapter 7
import java.util.Scanner;

public class GuessingGameMethod2   {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)   {
		prtln("Let's play a guessing game");

		do   {
			playRound();
		} while (askForAnotherRound());

		prtln("\nThank you for playing!");

	}

	private static void prtln(String s)  {  System.out.println(s); }
	private static void prt(String s)    {  System.out.print(s);   }

	private static void playRound()   {
		boolean bValidInput;
		int iNbr, iGuess;
		String sAnswer;

		// pick a random number
		iNbr = getRandomNumber();

		// get the guess

		prtln("\nI'm thinking of a number between 1 and 10 inclusive.");
	    prt("What do you think it is? ");
	    iGuess = getGuess();

	    // check the guess
	    if (iGuess == iNbr)
			prtln("By Jupiter, you're right!");
		else
			prtln("Sorry, the number was " + iNbr);
	}

	private static int getRandomNumber()   {
		return (int)(Math.random() * 9) + 1;
	}

	public static int getGuess()   {

		while (true)  {
			int iGuess = sc.nextInt();
			if ( iGuess < 1 || iGuess > 10 )
				prt("You must enter between 1 and 10.  Try again.");
			else
				return iGuess;
		}
	}

	private static boolean askForAnotherRound()  {
		while (true)   {
			String sAnswer;
			prt("\nPlay again (Y/N) ? ");
			sAnswer = sc.next();
			sAnswer = sAnswer.substring(0,1);
			if ( sAnswer.equalsIgnoreCase("y") )
				return true;
			else
				return false;
		}
	}

}
