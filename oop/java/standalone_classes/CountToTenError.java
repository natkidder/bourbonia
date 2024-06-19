// LB 183, book 2, chapter 5

public class CountToTenError   {

	public static void main(String Args[])  {

		try {
			for (int i = 1; i <= 10; i++)
				System.out.print(i + "   ");

			System.out.println();
			System.out.println("The final value of i is " + i);
		}
		catch (NoClassDefFoundError ncdfe)  {
			System.out.println(ncdfe.toString());
		}
	}
}
