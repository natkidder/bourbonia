package utilities;
import java.util.Scanner;

public class UtilityMedly  {

	public boolean bAskAgain()   {
		Scanner scKB = new Scanner(System.in);
		System.out.print("Another? (N) ");
		String sReply = scKB.nextLine();
		if ( sReply.equalsIgnoreCase("Y") )  {
			return true;
		}
		return false;
	}

}
