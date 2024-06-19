// LB 375, book 4, chapter 1
import java.util.Scanner;
import utilities.*;

public class StringBuilderApp  {

	static Scanner sc = new Scanner(System.in);
	static PrtObj p = new PrtObj();

	public static void main(String[] args)  {
		p.prt("Enter a string: ");
		String sAnswer = sc.nextLine();
		final String VOWELS = "AaEeIiOoUu";
		int iVowelCnt = 0;

		StringBuilder sbHideVowels = new StringBuilder(sAnswer);

		for (int i = 0; i < sAnswer.length(); i++)  {
			char cLetter = sAnswer.charAt(i);

			if ( VOWELS.indexOf(cLetter) > -1 )  {
				iVowelCnt++;
				sbHideVowels.setCharAt( i, '*' );
			}
		}
		p.prtln("\nVowel Count    : " + iVowelCnt);
		p.prtln("Original       : " + sAnswer);
		p.prtln("Vowels Hiddern : " + sbHideVowels.toString());
	}
}
