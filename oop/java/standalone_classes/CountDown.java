// LB 184, book 2, chapter 5
import java.util.Scanner;

public class CountDown   {

	static Scanner scIn = new Scanner(System.in);

	public static void main(String Args[])  {
		System.out.print("Enter a positive integer: ");
		int iHighest = scIn.nextInt();

		for ( int iCount = iHighest; iCount >= 1; iCount-- )  {
			System.out.println(iCount + "...");
		}
		System.out.println("We have ignition");
	}
}
