// LB 174, book 2, chapter 5
import java.util.*;

public class EvenCounter2  {

	static private Scanner scIn = new Scanner(System.in);

	public static void main(String[] args)   {
		try {
			System.out.print("Enter an even number less than or equal to 20: ");
			int i = scIn.nextInt();

			do   {
				System.out.print(i + "  ");
				i += 2;
			}  while (i <= 20);

			System.out.println();
		}
		catch (InputMismatchException ime)   {
			System.out.println("Please enter a whole number");
		}
	}
}
