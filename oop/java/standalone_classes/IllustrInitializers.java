// LB 269, book 3, chapter 2
// illustrates initializers
import utilities.*;
import java.util.Scanner;

public class IllustrInitializers    {
	public static void main(String args[])  {
		II2 ii2Test = new II2();
		ii2Test.TripleCounter();
		Prt.prtln("counter is now " + ++ii2Test.iX);
	}
}

class II2  {
	private Scanner sc = new Scanner(System.in);
	public int iX;

// initializer
	{
		Prt.prt("Enter the starting value for your counter: ");
		iX = sc.nextInt();
	}

	public II2()  {
		iX *= 2;
	}

	public void TripleCounter()  {
		iX *= 3;
	}
}
