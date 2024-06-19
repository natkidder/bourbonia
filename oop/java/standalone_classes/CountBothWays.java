// LB 186, book 2, chapter 5

public class CountBothWays  {

	public static void main(String args[])  {

		int iA, iB;   // can declare multiple variables on one line

		for (iA =1, iB = 10; iA <= 10 || iB >= -5 ; iA++, iB-- )
			System.out.println("iA = " + iA + ", iB = " + iB);
	}
}
