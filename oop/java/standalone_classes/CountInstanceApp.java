// LB 274, book 3, chapter 3
// Listing 3.1
import utilities.*;
import java.util.Scanner;

public class CountInstanceApp  {

	public static void main(String args[])  {
		printCount();
		for ( int i = 0; i < 10; i++ )  {
			CountTest ct1 = new CountTest();
			printCount();
		}
	}
	private static void printCount()  {
		Prt.prtln("There are now " + CountTest.getInstanceCount() + " instances of the CountTest class.");
	}
}

class CountTest  {
	public static int iInstanceCnt = 0;
	public CountTest()  {
		iInstanceCnt++;
	}
	public static int getInstanceCount()   {
		return iInstanceCnt;
	}
}
