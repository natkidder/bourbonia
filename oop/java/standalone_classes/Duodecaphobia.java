// LB 171, book 2, chapter 5
import java.util.Scanner;

public class Duodecaphobia  {

	private static Scanner scIn = new Scanner(System.in);

	public static void main(String[] args)  {
		prt("Enter an even integer less than 10: ");
        int iNumber = scIn.nextInt();
		while (true)   {
			if (iNumber >= 12)
                break;
			prt(iNumber + "  ");
			iNumber += 2;
		}
		System.out.println();   // newline
	}

	private static void prt(String s)  {
		System.out.print(s);
	}
}
