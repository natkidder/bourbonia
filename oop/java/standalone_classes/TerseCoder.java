// LB 185, book 2, chapter 5

public class TerseCoder  {

	public static void main(String args[])  {

		for (int i = 10; i >= 0; prtln(i-- + " ...") );
	}

	private static void prtln(String s) { System.out.println(s); }
}
