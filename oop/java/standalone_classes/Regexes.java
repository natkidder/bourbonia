//LB 497, book 5, chapter 4
import java.util.regex.*;
import java.util.Scanner;
import utilities.*;

public final class Regexes  {
	static String sRegex, sTest;
	static Pattern pttrnRegex;
	static Matcher mtchrPttrnStr;
	static boolean bMatch, bValidRegex, bDoneMatching;

	static PrtObj p = new PrtObj();

	public static Scanner scKB = new Scanner(System.in);

	public static void main(String[] args)  {
		p.prtln("Welcome to the Regex Tester");

		do  {
			do  {
				p.prt("\nEnter regex: ");
				sRegex = scKB.nextLine();
				bValidRegex = true;
				try  {
					Pattern pttrnRegex = Pattern.compile( sRegex );
				}
				catch ( Exception ex )   {
					p.prtln( ex.getMessage() );
					bValidRegex = false;
				}
			}while (! bValidRegex );

			bDoneMatching = false;

			while ( !bDoneMatching )   {
				p.prt("Enter test string: ");
				sTest = scKB.nextLine();
				if ( sTest.length() == 0 )  {
					bDoneMatching = true;
			    } else  {
					mtchrPttrnStr = pttrnRegex.matcher( sTest );
					if ( mtchrPttrnStr.matches() )   {
						p.prtln("'" + sTest + "' matches '" + sRegex + "'");
					}  else   {
						p.prtln("'" + sTest + "' does not match '" + sRegex + "'");
					}
				}
			}
		} while ( bAskAgain() );
	}

	private static boolean bAskAgain()   {
		p.prtln("Another? (N) ");
		String sReply = scKB.nextLine();
		if ( sReply.equalsIgnoreCase("Y") )  {
			return true;
		}
		return false;
	}
}
