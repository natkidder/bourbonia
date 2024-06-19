// LB 460, book 5, chapter 1

public class CountDownClockSync extends Thread  {

	static int iStart;
	public static int iInstanceCnt = 0;

	public CountDownClockSync( int iStart )  {
		this.iStart = iStart;
	}

/* NOTE the synchronized.  Now no two threads than access it at once */

	public synchronized void run() {

		iInstanceCnt++;
		System.out.println("Instance " + iInstanceCnt);
		for (int iMinus = iStart; iMinus >= 0; iMinus--)  {
			System.out.println("T minus " + iMinus);
			try  {
				Thread.sleep(1000);
			}
			catch (InterruptedException ie)  {
			}
		}
	}
}
