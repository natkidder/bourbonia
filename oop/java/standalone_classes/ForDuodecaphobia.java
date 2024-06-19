// LB 188, book 2, chapter 5

public class ForDuodecaphobia  {

	public static void main(String[] args)  {

		for (int iEven = 2; iEven <= 20; System.out.print("  in loop spec\n"), iEven += 2)  {
			if (iEven == 12)
				break;
			System.out.print(iEven + "  in loop body  ");
		}
		System.out.println();
	}
}
