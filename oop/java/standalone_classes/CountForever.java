// LB 171, book 2, chapter 5
import java.util.Scanner;

public class CountForever  {

    private static Scanner scChar = new Scanner(System.in);

	public static void main(String[] args)  {
		System.out.println("To end the program, close the console window");
		prt("Press Ent to Cont: ");
		String sRtn = scChar.nextLine();
		int iNbr = 2;
		while (true)  {
			prt(iNbr + "  ");
			iNbr += 2;
		}
	}

	private static void prt(String s)  {
		System.out.print(s);
	}
}
