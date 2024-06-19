// LB 211, book 2, chapter 6
//import PrintMethods.*;

public class RandomNumber  {

	public static void main(String[] args)   {
		int iNbr = getRandomNumber();
		System.out.println("The Random number is " + iNbr);
	}

	private static int getRandomNumber()  {
		int iNbr = (int)(Math.random() * 10) + 1;
		return iNbr;
	}
}
