// LB 266, book 3, chapter 2
/* NOTE: originally coded to show a class that cannot compile */
import utilities.*;

public class ActorApp   {
	public static void main(String[] args)   {

		Actor a = new Actor();  // will compile if actor has no constructor a an explicit argumentless one
		Prt.prtln("Name: " + a.getLastName() + ", " + a.getFirstName() + ": was (s)he good? " + a.isGoodActor().toString() );
		Actor2 a2 = new Actor2("Widmark", "Richard", true);
		Prt.prtln("Name: " + a2.getLastName() + ", " + a2.getFirstName() + ": was (s)he good? " + a2.isGoodActor().toString() );
	}
}

/*class Actor   {

	private String sLastName;
	private String sFirstName;
	private boolean bGoodActor;

// MUST declare a default constructor, as you have argumented constructors
	public Actor()  {
		sLastName = "Patrick";
		sFirstName = "McGowan";
		bGoodActor = true;
	}

	public Actor(String sLast, String sFirst)   {

		sLastName = sLast;
		sFirstName = sFirst;
	}

	public Actor(String sLast, String sFirst, boolean bGood)  {

		sLastName = sLast;
		sFirstName = sFirst;
		bGoodActor = bGood;
	}
}
*/
