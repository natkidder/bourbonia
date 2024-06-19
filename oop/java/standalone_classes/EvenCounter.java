// LB 168, book 2, chapter 5
import java.util.Scanner;

public class EvenCounter  {

    private static Scanner scIn = new Scanner(System.in);

// main MUST be public
	public static void main(String[] args)  {
		prt("Enter start integer: ");
		int iStart = scIn.nextInt();
		prt("Enter step integer: ");
		int iStep = scIn.nextInt();
		prt("Enter final integer: ");
        int iEnd = scIn.nextInt();
		int iIterations = 0;
		int iCurr = iStart;
		while (iCurr <= iEnd)  {
			prt(iCurr + "  ");
			iCurr += iStep;
			iIterations++;
			if (iIterations > 100)   {
				break;
			}
		}
		System.out.println("");
	}

	private static void prt(String s)   {
		System.out.print(s);
	}
}
