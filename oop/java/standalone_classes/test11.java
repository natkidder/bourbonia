// LB 231, book 2, chapter 8
import java.util.*;
import utilities.*;

public class GetInteger2   {

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[])  {
		Prt.prt("Enter an integer: ");
		int i = getInteger();
		Prt.prtln("You entered " + i);
	}

	public static int getInteger()   {
System.out.println("before while: " + sc.hasNextInt());
		while ( ! sc.hasNextInt() )   {
System.out.println("top of while: " + sc.hasNextInt());
			sc.nextLine();  //seems to go directly to this line before evaluating anything else
			Prt.prt("That's not an integer.  Try again: " );
System.out.println("bottom of while: " + sc.hasNextInt());
		}
System.out.println("after while: " + sc.hasNextInt());
		return sc.nextInt();
	}
}
