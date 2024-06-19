// LB 367, book 4, chapter 1
import java.util.Scanner;
import utilities.*;

public class CountStringCharacters  {

	static Scanner sc = new Scanner(System.in);
	static PrtObj p = new PrtObj();

	public static void main(String[] args)  {
		p.prt("Enter a string: ");
		String sAnswer = sc.nextLine();
		String sVowels = "AaEeIiOoUu";

		int iVowelCnt = 0;

		for (int i = 0; i < sAnswer.length(); i++)  {
			char c = sAnswer.charAt(i);
			if ( sVowels.indexOf(c) > -1 )  {
				iVowelCnt++;
			}
		}
		p.prtln("That string contains " + iVowelCnt + " vowels");
	}
}
