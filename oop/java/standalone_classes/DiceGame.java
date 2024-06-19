// LB 258, book 3, chapter 2
import utilities.*;

public class DiceGame  {

	public static void main(String[] args)  {

		Dice d = new Dice();
		int iResult = d.roll();
		System.out.println("you rolled a " + iResult);
	}
}

class Dice   {
	public int roll()   {
		int i = 0;
        try {
			i = (int)(Math.random() * 6) + 1;
		}
		catch ( ArithmeticException ae )  {
			Prt.prtln( ae.toString() + ": aritmetic exception");
		}
		finally  {
			return i;
		}
	}
}

