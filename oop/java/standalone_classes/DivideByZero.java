// LB 227, book 2, chapter 8
public class DivideByZero   {

	private static void prtln(String s)  {   System.out.println(s);  }

	public static void main(String args[])   {

		final int iA = 5;
		final int iB = 0;

		try    {
			int iC = iA / iB;
		}

		catch (ArithmeticException ae)   {
			prtln(ae.toString() + ": Oops, you cannot divide by zero");
		}
	}
}
