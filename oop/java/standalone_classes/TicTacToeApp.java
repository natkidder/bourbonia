// LB 294, book 3, chapter 4

public class TicTacToeApp  {

	public static void main(String args[])   {

		Player2 p1 = new Player2();
		Player2 p2 = new BetterPlayer();
// the arguments' TYPES must conform to the method's signature
		playTheGame(p1, p2);
	}

	public static void playTheGame(Player2 p1, Player2 p2)  {

		p1.move();
		p2.move();
	}
}
