// LB 139  Book 2, Chapter 3
public class RoundingApp   {
	public static void main(String[] args)  {
		double dX = 29.4;
		double dY = 93.5;
		double dZ = -19.3;

		prtln("round(" + dX + ")			= " + Math.round(dX));
		prtln("round(" + dY + ")			= " + Math.round(dY));
		prtln("round(" + dZ + ")			= " + Math.round(dZ) + "\n");

		prtln("ceil(" + dX + ")			= " + Math.ceil(dX));
		prtln("ceil(" + dY + ")			= " + Math.ceil(dY));
		prtln("ceil(" + dZ + ")			= " + Math.ceil(dZ) + "\n");

		prtln("rint(" + dX + ")			= " + Math.rint(dX));
		prtln("rint(" + dY + ")			= " + Math.rint(dY));
		prtln("rint(" + dZ + ")			= " + Math.rint(dZ));
	}

	private static void prtln(String s)  {
		System.out.println(s);
	}
}
