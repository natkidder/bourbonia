// LB 188, book 2, chapter 5

public class ForDuodecaphobia2  {

	public static void main(String[] args)  {

		for ( int iEven =2; iEven <= 20; iEven +=2 )  {
			if (iEven == 12)
				continue;
			System.out.println(iEven + "  ");
		}
		System.out.println();
	}
}
