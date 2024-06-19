// LB 202, book 2, chapter 6
import java.util.Scanner;

public class CarWashApp2   {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)  {
		prtln("The car wash application\n\n");
		prt("Enter the package code: ");
		String sCode = sc.next();

		char cCode = sCode.charAt(0);
		prtln("cCode = " + cCode); ////

		String sDetails = "";

		switch (cCode)  {
			case 'E':
			case 'e':
				sDetails = packageE() + packageD() + packageC() + packageB() + packageA();
				break;
			case 'D':
			case 'd':
				sDetails = packageD() + packageC() + packageB() + packageA();
				break;
			case 'C':
			case 'c':
				sDetails = packageC() + packageB() + packageA();
				break;
			case 'B':
			case 'b':
				sDetails = packageB() + packageA();
				break;
			case 'A':
			case 'a':
				sDetails = packageA();
				break;
			default:
				sDetails = "That's not one of the codes.";
				break;
		}
		prtln("That package includes:\n");
		prtln(sDetails);
	}

	private static String packageA()   {
		return "\tWash, vaccuum and hand-dry\n";
	}

	private static String packageB()  {
		return "\tWas, plus ...\n";
	}

	private static String packageC()   {
		return "\tLeather/Vinyl treatment ...\n";
	}

	private static String packageD()  {
		return "\tTire treatment ...\n";
	}

	private static String packageE()  {
		return "\tNew car scent, plus ...\n";
	}

	private static void prt(String s)  {  System.out.print(s); }
	private static void prtln(String s) {  System.out.println(s); }
}
