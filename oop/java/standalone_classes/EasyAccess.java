// LB 261, book 3, chapter 2
import utilities.*;

public class EasyAccess  {

	public static void main(String args[])  {
		Example eObj = new Example();
		eObj.setProp1(17);
		int iTest = eObj.getProp1();
		eObj.setProp2(999999999);
		long iTest2 = eObj.getProp2();
		Prt.prtln("iTest1 = " + iTest + ", iTest2 = " + iTest2);
	}
}

class Example  {

	private int property1;
	private long property2;

	protected int getProp1()  {
		return property1;
	}
	public void setProp1(int iProp1)  {
		property1 = iProp1;
	}

	public long getProp2()  {
		return property2;
	}
	public void setProp2(long iProp2)  {
		property2 = iProp2 > Math.pow(10, 6) ? 999999 : iProp2;
/*		if (iProp2 > Math.pow(10,6))
			property2 = 999999;
		else
			property2 = iProp2;
*/
	}

}
