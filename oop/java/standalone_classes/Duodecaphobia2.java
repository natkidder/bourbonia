// LB 174, book 2, chapter 5
import java.util.*;

public class Duodecaphobia2  {

	private static Scanner scIn = new Scanner(System.in);

	public static void main (String[] args)   {
		try {
			int iNbr = 0;
			System.out.print("Enter an even integer less than 20: ");
			int iSkip = scIn.nextInt();
			int i = 0;
			while (i < 20)  {
				i += 2;
				if (i == iSkip)   {

					continue;

				}
				System.out.print(i + "  ");
			}
			System.out.println();
		}
		catch (InputMismatchException ime)  {
			System.out.println("Enter a whole number, please");
			//ime.printStackTrace(System.out);
		}
	}
}
