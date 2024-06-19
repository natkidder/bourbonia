// LB 382, book 4, chapter 2
import utilities.*;

public class ArrayUsage  {

	static PrtObj p = new PrtObj();

	public static void main(String args[])  {

		// true = open, false = closed
		boolean bLockers[] = new boolean[1001];

		// close all of the lockers
		for (int i = 0; i < 1001; i++)
			bLockers[i] = false;

		for (int iSkip = 1; iSkip < 1001; iSkip++)  {

			p.prtln("Bobo is changing " + iSkip + " lockers");

			for (int iLocker = iSkip; iLocker < 1000; iLocker += iSkip)
				bLockers[iLocker] = !bLockers[iLocker];

		}

		p.prtln("Bobo is bored, so he's going home");

		// count and list the open lockers
		String sList = "";
		int iOpenCnt = 0;

		for (int i = 1; i < 1001; i++)  {
			if ( bLockers[i] )  {
				iOpenCnt++;
				sList += i + " ";
			}
		}

		p.prtln("Bobo left " + iOpenCnt + " lockers open");
		p.prtln("The open lockers are: " + sList);
	}
}

