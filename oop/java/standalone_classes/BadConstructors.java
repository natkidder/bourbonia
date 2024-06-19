// LB 267, book 3, chapter 2

public class BadConstructors  {
	private String firstString;
	private String secondString;

	public BadConstructors(String first, String second)  {
		this(first);
		secondString = second;
	}
	public BadConstructors(String first)  {
		this(first, "secondLiteral");  // ERROR: will not compile
	}
}
