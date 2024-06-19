// LB 267, book 3, chapter 2
/* will not compile, since constructors cannot call each other */

public class CrazyClass   {

	private String firstString;
	private String secondString;

	public CrazyClass(String first, String second)   {

		this(first);
		secondString = second;
	}

	public CrazyClass(String first)  {
		this(first, "DEFAULT");  // ERROR, will not compile
	}
}
