// LB 383, book 4, chapter 2
import utilities.*;

public class EnhancedFor  {

	static PrtObj p = new PrtObj();

	public static void main(String args[])  {

		String sDOW[] = getDOW();

		for ( String sDay : sDOW )
			p.prt(sDay + " ");

		p.prtln("");
	}

	// NOTE a function can return an entire array, not just it's reference
	private static String[] getDOW()  {
		String sDays[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		return sDays;
	}
}
