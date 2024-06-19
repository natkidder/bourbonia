// LB 165, book 2, chapter 4
import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerApp   {
    static Scanner scIn = new Scanner(System.in);

	public static void main(String[] args)  {
		try  {
			System.out.print("Enter an integer: ");
			int iX = scIn.nextInt();
			System.out.println("You entered " + iX + ".");
		}
		catch (InputMismatchException ime)  {
			System.out.println("Printing stack trace ...\n");
			ime.printStackTrace(System.out);
		}
	}
}
