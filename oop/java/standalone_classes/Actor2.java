// LB 266, book 3, chapter 2

public class Actor2  {
	private String LastName;
	private String FirstName;
	private Boolean bGoodActor;

	public Actor2(String lName, String fName)  {
		this.LastName = lName;  // class variable, hence 'this' is optional
		this.FirstName = fName;
	}
	public Actor2(String lName, String fName, boolean bGood)  {
		this(lName, fName);  // MUST be first statement in constructor
		bGoodActor = bGood;  // no 'this'
	}

	public void setLastName( String last )   {
		this.LastName = last;
	}
	public void setFirstName( String first )  {
		this.FirstName = first;
	}
	public void setGoodActor( Boolean good )  {
		this.bGoodActor = good;
	}
	public String getLastName()  {
		return this.LastName;
	}
	public String getFirstName()  {
		return this.FirstName;
	}
	public Boolean isGoodActor()  {
		return this.bGoodActor;
	}
}
