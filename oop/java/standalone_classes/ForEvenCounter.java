// LB 183, book 2, chapter 5
import java.util.Scanner;

public class ForEvenCounter   {

	static Scanner scIn = new Scanner(System.in);

	public static void main(String Args[])  {
		try {
			System.out.print("Enter a positive even integer: ");
			int iHighest = scIn.nextInt();

			for ( int iEven = 2; iEven <= iHighest; iEven += 2 )
				System.out.print(iEven + "  ");
			System.out.println();
		}
		catch(java.util.InputMismatchException ime)   {
			System.out.println(ime.toString() + ": Please enter a whole number");
		}
	}
}
