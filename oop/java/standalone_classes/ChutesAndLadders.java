// example of using switch to play Chutes and Ladders
public class ChutesAndLadders  {

	public static void main(String args[])  {
		int gamesCnt = 0;
		int cumTurns = 0;
		int currTurns;
		int minTurns = 99999;
		int maxTurns = 0;
		double meanTurns;
		while (gamesCnt <= 100)  {
			currTurns = game();
			cumTurns += currTurns;
			minTurns = minTurns < currTurns ? minTurns : currTurns;
			maxTurns = maxTurns > currTurns ? maxTurns : currTurns;
			gamesCnt++;
			System.out.print(currTurns + " ");
		}
		meanTurns = cumTurns / gamesCnt;
		prtln("\nOn average, it takes " + meanTurns + " spins for an individual to finish Chutes and Ladders.");
		prtln("The lowest number of spins was  " + minTurns);
		prtln("The highest number of spins was " + maxTurns);
	}

	public static int game() {
		int spin;
		int currSpace = 0;
		int turnCnt = 0;

		while (currSpace != 100)  {
			spin = (int)(Math.random() * 6) + 1;
//			prtln("Spin: " + spin + ", space: " + currSpace);  ////
			currSpace = currSpace + spin;
			turnCnt++;

			// spins that take you past 100 don't count
			if (currSpace > 100)
				currSpace = currSpace - spin;

			switch (currSpace)  {
				case 1:
					currSpace = 38;
					break;
				case 4:
					currSpace = 14;
					break;
				case 9:
					currSpace = 31;
					break;
				case 16:
					currSpace = 6;
					break;
				case 21:
					currSpace = 42;
					break;
				case 28:
					currSpace = 84;
					break;
				case 36:
					currSpace = 44;
					break;
				case 48:
					currSpace = 26;
					break;
				case 49:
					currSpace = 11;
					break;
				case 51:
					currSpace = 67;
					break;
				case 56:
					currSpace = 53;
					break;
				case 62:
					currSpace = 19;
					break;
				case 64:
					currSpace = 60;
					break;
				case 71:
					currSpace = 91;
					break;
				case 80:
					currSpace = 100;
					break;
				case 87:
					currSpace = 24;
					break;
				case 93:
					currSpace = 73;
					break;
				case 95:
					currSpace = 75;
					break;
				case 98:
					currSpace = 78;
					break;
				default:
					currSpace = currSpace;
					break;
			}
		}
		return turnCnt;
	}

	private static void prtln(String s) { System.out.println(s); }
}
