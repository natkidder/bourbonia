// LB 108, book 2, chapter 2
public class ScopeApp   {
	static int iX;

	public static void main(String args[])  {
		iX = 5;
		System.out.println("main: iX = " + iX);
		myMethod();
	}

	public static void myMethod()  {
		int iY;
		iY = 10;
		if (iY == iX + 5)  {
			int iZ;
			iZ = 15;
			System.out.println("myMethod: iZ = " + iZ);
		}
		System.out.println("myMethod: iX = " + iX);
		System.out.println("myMethod: iY = " + iY);
	}
}
