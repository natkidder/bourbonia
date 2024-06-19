// LB 266, Book 3, Chapter 2

public class BadActorApp  {

	public static void main(String args[])  {
		Actor aComic = new Actor(); // will NOT work, as there are explict constructors w/ at least one parameter
	}
}

class Actor  {
	private String lastName;
	private String firstName;
	private boolean bGoodActor;

	public Actor(String lName, String fName)  {
		lastName = lName;
		firstName = fName;
	}

	public Actor(String lName, String fName, boolean bGood)  {
		lastName = lName;
		firstName = fName;
		bGoodActor = bGood;
	}
}
