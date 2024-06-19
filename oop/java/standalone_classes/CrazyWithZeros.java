// LB 233, book 2, chapter 8
import utilities.*;

public class CrazyWithZeros   {

	public static void main(String[] args)   {

		try   {
			int iAnswer = divideTheseNumbers( 5 , 0 );
		}
		catch ( Exception e )   {
			Prt.prtln("main catch: Tried twice, still did not work");
		}
	}

	public static int divideTheseNumbers(int iNumerator, int iDenominator)
		throws Exception   {

		int iRtn;

		try   {
			iRtn = iNumerator / iDenominator;
			Prt.prtln("divideTheseNumbers Try: It worked!");
		}

		catch ( Exception e )  {
			Prt.prtln("divideTheseNumbers catch: Did not work in Try.");
// Alternately comment and uncomment the below to see alternate output
//			iDenominator = 2;
			iRtn = iNumerator / iDenominator;
			Prt.prtln("divideTheseNumbers catch: Did work in catch.");
		}

		finally  {
			Prt.prtln("divideTheseNumbers finally: better clean up my mess");
		}

		Prt.prtln("divideTheseNumbers main: It worked after all");
		return iRtn;
	}
}
