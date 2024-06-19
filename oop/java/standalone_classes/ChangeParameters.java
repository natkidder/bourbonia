// LB 219, Book 2, Chapter 7

public class ChangeParameters   {

	public static void main(String args[])   {

		int iParam = 1;
		tryToChangeNumber(iParam);
		System.out.println("if iParam = 1, then pass-by-value\nif iParam = 3, then pass-by-reference");
		System.out.println("iParam = " + iParam);
	}

	protected static void tryToChangeNumber(int i)   {
		i = 3;
	}
}
