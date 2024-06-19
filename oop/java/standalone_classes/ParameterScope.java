// LB 218, Book 2, Chapter 7

public class ParameterScope   {

	public static void main(String args[])   {

		final int iMin = 1;
		final int iMax = 10;
		int iNbr = getRandomNumber(iMin, iMax);
		System.out.println("Your random number is: " + iNbr);
	}

	private static int getRandomNumber(int iMin, int iMax)  {
		return (int)(Math.random() * iMax) + iMin;
	}

}
