// LB 164  Book 2, Chapter 4
import java.util.Scanner;

public class ConditionalOperator  {

	private static Scanner scIn = new Scanner(System.in);

	public static void main(String args[])  {
		System.out.print("Enter a whole number between zero and 100: ");
		int iX = scIn.nextInt();

		boolean bUpperTier = iX > 50 ? true : false;

		if (bUpperTier)  {
			System.out.println(iX + " is closer to 100 than zero");
		} else {
			System.out.println(iX + " is closer to zero than 100");
		}
	}
}
