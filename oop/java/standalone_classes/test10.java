// LB 227, book 2, chapter 8
import java.util.*;

public class GetInteger   {

	static Scanner sc = new Scanner(System.in);
	static void prtln(String s) {  System.out.println(s);  }
	static void prt(String s)  {  System.out.print(s);   }

	public static void main(String args[])   {

		prt("Enter an integer: ");
		int i = getInteger();
		prtln("You entered " + i);
	}

	public static int getInteger()   {

		while (true)  {

			try  {
				return sc.nextInt();
			}
			catch (InputMismatchException e)  {
				prt("That's not an integer, try again: ");
				sc.next();  // need to prompt for a string here; an int will return you to the try
			}
		}
	}
}
