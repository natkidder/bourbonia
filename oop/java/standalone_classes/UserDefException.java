// LB 239, book 2, chapter 8
import utilities.*;

public class UserDefException  {

	public static void main(String args[])  {

		try  {
			doSomething( true );
		}
		catch ( Exception2 e )  {
			Prt.prtln("Exception2 e thrown by main()");
			Prt.prtln( e.sExplanation());
		}
	}

	public static void doSomething( boolean b )
		throws Exception2   {

			if ( b )  {
				throw new Exception2();
			}
	}

	static class Exception2 extends Exception {
		public String sExplanation()  {
			return "Exception2.sExplanation(): thrown exception";
		}
	}
}


