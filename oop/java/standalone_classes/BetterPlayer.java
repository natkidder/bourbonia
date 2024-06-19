// LB 293, book 3, chapter 4
import utilities.*;

class BetterPlayer extends Player2   {

	public int move()   {

		Prt.prtln("\nThe better player says: ");
		Prt.prtln("I'm looking for a good move.");
		return findBestMove();
	}

	private int findBestMove()   {

		int iSquare;
		iSquare = (int)(Math.random() * 8) + 1;
		return iSquare;
	}
}
