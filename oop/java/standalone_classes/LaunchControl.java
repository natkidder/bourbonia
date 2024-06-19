// LB 184, book 2, chapter 5

public class LaunchControl  {

	public static void main(String[] args)  {
		System.out.print("We are go for launch in T minus ");

		for (int iCount = 10; iCount >= 0; iCount--)   {
			if (iCount == 8)
				prtln("Ingnition sequence start!");
			else
				prtln(iCount + "...");
		}
		prtln("All engines running!");
		prtln("Liftoff!  We have liftoff!");
	}

	private static void prtln(String s)  { System.out.println(s);  }
}
