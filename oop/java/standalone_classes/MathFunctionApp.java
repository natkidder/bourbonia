// LB 134  Book 2, Chapter 3
public class MathFunctionApp  {
	public static void main(String apps[])  {

		int iA = 100;
		int iB = 0 - 50;
		int iC = 3;
		double dX = 25.0;
		double dY = 3.0;
		double dZ = 4.0;

		prtln("iA			= " + iA);
		prtln("iB			= " + iB);
		prtln("iC			= " + iC);
		prtln("dX			= " + dX);
		prtln("dY			= " + dY);
		prtln("dZ			= " + dZ + "\n");
		prtln("abs(" + iB + ")		= " + Math.abs(iB));
		prtln("cbrt(" + dX + ")		= " + Math.cbrt(dX));
		prtln("exp(" + dY + ")		= " + Math.exp(dY));
		prtln("hypot(" + dY + ", " + dZ + ")		= " + Math.hypot(dY, dZ));
		prtln("log(" + dY + ")		= " + Math.log(dY) + "\n");
		prtln("log10(" + dY + ")		= " + Math.log10(dY));
		prtln("max(" + iA + ", " + iB + ")		= " + Math.max(iA, iB));
		prtln("min(" + iA + ", " + iB + ")		= " + Math.min(iA, iB));
		prtln("pow(" + iA + ", " + iC + ")		= " + Math.pow(iA, iC));
		prtln("random()		= " + Math.random() + "\n");
		prtln("signum(" + iB + ")		= " + Math.signum(iB));
		prtln("sqrt(" + dX + ")		= " + Math.sqrt(dX));
	}

	private static void prtln(String s)  {
		System.out.println(s);
	}
}
