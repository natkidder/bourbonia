// LB 367, book 4, chapter 1
import java.util.Scanner;
import utilities.*;

public class ReplaceStringCharacters  {

	static Scanner sc = new Scanner(System.in);
	static PrtObj p = new PrtObj();

	public static void main(String[] args)  {
		p.prt("Enter a string: ");
		String sAnswer = sc.nextLine();
		String sOrig = sAnswer;
		final String sVowels = "aAeEiIoOuU";
		int iVowelCnt = 0;

		for (int i = 0; i < sAnswer.length(); i++)  {
			char c = sAnswer.charAt(i);
			if ( sVowels.indexOf(c) > -1)  {
				String sFront = sAnswer.substring(0, i);
				String sBack = sAnswer.substring(i + 1);
				sAnswer = sFront + "*" + sBack;
			}
		}
		p.prtln("");
		p.prtln(sOrig);
		p.prtln(sAnswer);
	}
}
