// LB 274, book 3, chapter 3
import utilities.*;

public class CountTestApp   {

	public static void main(String[] args)   {

		printCount();
		for (int i = 0; ; i++)   {
			CountTest ct = new CountTest();
			printCount();
			if ( i >= 10 )  {  break;  }
		}
	}

	private static void printCount()   {

		Prt.prtln("There are now " + CountTest.getInstanceCnt() + " instances of the CountTest class.");
	}
}

class CountTest  {

	private static int iInstanceCnt = 0;

	public CountTest()  {
		iInstanceCnt++;
	}

	public static int getInstanceCnt()   {

		return iInstanceCnt;
	}
}


