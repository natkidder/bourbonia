// LB 266, book 3, chapter 2
public class Actor   {

	private String LastName;
	private String FirstName;
	private Boolean bGoodActor;

// MUST declare a default constructor, as you have argumented constructors
	public Actor()  {
		LastName = "Patrick";
		FirstName = "McGowan";
		bGoodActor = true;
	}

	public Actor(String last, String first)  {

		LastName = last;
		FirstName = first;
	}

	public Actor(String last, String first, Boolean bGood)  {

/* note use of 'this' below, and it's the first non-comment line*/

		this(last, first);
		this.bGoodActor = bGood;
	}

	public void setLastName( String last )  {
		this.LastName = last;
	}
	public void setFirstName( String first )  {
		this.FirstName = first;
	}
	public void setGoodActor( Boolean bGood )  {
		this.bGoodActor = bGood;
	}
	public String getLastName()  {
		return this.LastName;
	}
	public String getFirstName()   {
		return this.FirstName;
	}
	public Boolean isGoodActor()   {
		return this.bGoodActor;
	}

}
