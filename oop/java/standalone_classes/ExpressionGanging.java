// LB 186, book 2, chapter 5

public class ExpressionGanging  {

	public static void main(String[] args)  {

		prt("\nWe are go for launch in T minus ");

		for (int iCnt = 10; iCnt >= 0;
			prt(iCnt == 8 ? "Ignition sequence start ...\n" : iCnt + " ...\n"), iCnt-- );

		prt("\nAll engines running!");
		prt("\nLiftoff!  We have liftoff!\n");
	}

	private static void prt(String s) {  System.out.print(s); }
}
