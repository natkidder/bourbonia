// LB 420, book 4, chapter 4
import utilities.PrtObj;
import java.util.*;

public class LinkedListExample  {

	static PrtObj p = new PrtObj();
	static Scanner sc = new Scanner(System.in);
	static String sResp = "";

	public static void main(String args[])  {

/* <Object> can be any object, including user-defined */
		LinkedList<String> llTeams = new LinkedList<String>();

		llTeams.add("New York");

		llTeams.addFirst("Boston");

		llTeams.add("Baltimore");
		llTeams.add( 2, "Toronto" );
		llTeams.addLast("Tampa Bay");

		p.prtln("1");
		for ( String sTeam : llTeams  )  { p.prtln(sTeam); }

		p.prtln("2");
		llTeams.set(1, "Baltimore");
		llTeams.set(3, "New York");
		for ( String sTeam : llTeams ) { p.prtln(sTeam); }

		p.prtln("3");
/* can also use the index number as the argument */
		llTeams.remove("New York");
		for ( String sTeam : llTeams )  { p.prtln(sTeam); }

		p.prtln("4");
		llTeams.remove();
		p.prtln("Linked list now has " + llTeams.size() + " elements" );

	}
}
