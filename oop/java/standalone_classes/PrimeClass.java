// LB 269, book 3, chapter 2
// illustrates initializers
import java.util.Scanner;

class PrimeClass   {

	private Scanner sc = new Scanner(System.in);

	public Integer i;

// initializer
	{
		System.out.print("Enter the starting value of integer i: ");
		i = sc.nextInt();
	}
}
