// LB 201, book 2, chapter 6
import java.util.Scanner;

public class CarWashApp   {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)  {
		prtln("The car wash application\n\n");
		prt("Enter the package code: ");
		String sCode = sc.next();

		char cCode = sCode.charAt(0);

		String sDetails = "";

		switch (cCode)  {
			case 'E':
			case 'e':
				sDetails = "\tNew Car Scent, plus ...\n";
				break;
			case 'D':
			case 'd':
				sDetails = "\tTire Treatment, plus ...\n";
				break;
			case 'C':
			case 'c':
				sDetails = "\tLeather/Vinyl Treatment, plus ...\n";
				break;
			case 'B':
			case 'b':
				sDetails = "\tWax, plus ...\n";
				break;
			case 'A':
			case 'a':
				sDetails = "\tWash, Vacuum, and Hand Dry\n";
				break;
			default:
				sDetails = "That's not one of the codes.\n";
				break;
		}
		prtln("\nThat package includes:\n");
		prtln(sDetails);
	}

	private static void prt(String s) { System.out.print(s); }
	private static void prtln(String s) { System.out.println(s); }
}
