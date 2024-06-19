// LB 370, book 4, chapter 1
import java.util.Scanner;
import utilities.*;

public class CountWords  {

	static Scanner sc = new Scanner(System.in);
	static PrtObj p = new PrtObj();

	public static void main(String[] args)  {
		p.prt("Enter a string: ");
		int iWordCnt = 0;
		String sAnswer = sc.nextLine();
		String[] sWords = sAnswer.split("\\s+");
		for ( String sWord : sWords )   {
			p.prtln(sWord);
			iWordCnt++;
		}
		p.prtln("Word count: " + iWordCnt);
	}
}
