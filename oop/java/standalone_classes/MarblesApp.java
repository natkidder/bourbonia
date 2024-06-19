// LB 122  Book 2, Chapter 3
import java.util.Scanner;

public class MarblesApp   {

	static Scanner scIn = new Scanner(System.in);

	public static void main(String args[])  {

		int iNbrOfMarbles;
		int iNbrOfChildren;
		int iMarblesPerChild;
		int iMarblesLeftOver;

		System.out.println("Welcome to the marble divvy upper.");
		System.out.print("Number of marbles: ");
		iNbrOfMarbles = scIn.nextInt();
		System.out.print("Number of children: ");
		iNbrOfChildren = scIn.nextInt();

		iMarblesPerChild = iNbrOfMarbles / iNbrOfChildren;
		iMarblesLeftOver = iNbrOfMarbles % iNbrOfChildren;

		System.out.println("Give each child " + iMarblesPerChild + " marbles");
		System.out.println("You will have " + iMarblesLeftOver + " marbles for charity.");
	}
}
