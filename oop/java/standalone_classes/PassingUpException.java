// LB 239, book 2, chapter 8
import utilities.*;

public class PassingUpException  {

	public static void main(String args[])  {

		try  {
			float fResult = Divide( 5, 0 );
			doSomething( true );
		}
		catch ( ArithmeticException ae ) {
			Prt.prtln( ae.toString() + ": divided by zero");
		}
		catch ( Exception e )  {
			Prt.prtln("Exception e thrown by main()");
		}
	}

	public static void doSomething( boolean b )
		throws Exception   {

			if ( b )  {
				throw new Exception();
			}
	}

	private static float Divide(int iNumerator, int iDenominator)  throws ArithmeticException  {
		float fResult = iNumerator / iDenominator;
		return fResult;
	}

}


