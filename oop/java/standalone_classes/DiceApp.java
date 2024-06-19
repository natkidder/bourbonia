// LB 137  Book 2, Chapter 3

public class DiceApp   {

	public static void main(String apps[])  {

		int iRoll;
		String sMsg = "Here are 100 random rolls of the dice:";
		System.out.println(sMsg);

		for (int i = 0; i < 100; i++)  {
			iRoll = randomInt(1, 6);
			System.out.print(iRoll + " ");
		}
		System.out.println();
	}

	private static int randomInt(int iLow, int iHigh)  {

		int iResult = (int)(Math.random() * (iHigh - iLow + 1)) + iLow;
		return iResult;
	}
}
