// LB 293, book 3, chapter 4
import utilities.*;

class Player2   {

	public int move()  {

		for (int i = 0; i < 9; i++)  {
			Prt.prtln("\nThe basic player says:");
			Prt.prtln("I'll take the first open square!");
			return firstOpenSquare();
		}
		return -1;
	}

	private int firstOpenSquare()   {

		int iSquare = (int)(Math.random() * 8) + 1;
		return iSquare;
	}
}
