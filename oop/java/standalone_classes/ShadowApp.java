// LB 109, book 2, chapter 2
public class ShadowApp   {
	static int iX;

	public static void main(String args[])  {
		iX = 5;
		System.out.println("Not yet shadowed: iX = " + iX);
		int iX;
		iX = 10;
		System.out.println("Shadowed: iX = " + iX);
		// illustrates how to use a class variable
		System.out.println("ShadowApp.iX = " + ShadowApp.iX);
	}
}
