// LB 261, book 3, chapter 2
/* Works with Player class */
import utilities.*;
import java.util.*;

public class WorksWithPlayer  {

	static public Scanner scIn = new Scanner(System.in);

	public static void main(String args[])  {
		boolean bNeedInt = true;
		do {
			try {
				Player playerTest = new Player();
				Prt.prt("Enter an integer: ");
				Integer iHealth = scIn.nextInt();
				bNeedInt = false;
				playerTest.setHealth(iHealth);
				iHealth = playerTest.getHealth();
				Prt.prtln("Your health is " + iHealth.toString());
			}
			catch ( InputMismatchException ime )  {
				Prt.prtln( ime.toString() + ": need to enter an integer");
				break;   //needs work
			}
		}
		while ( bNeedInt );
	}
}
