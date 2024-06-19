// LB 446, book 5, chapter 1
import utilities.PrtObj;
import java.util.*;

public class ThreadExample  {

	public static void main(String[] args) {
		Thread thrCountDown = new RunsThreadExample(10);
		thrCountDown.start();
	}
}

class RunsThreadExample extends Thread  {

	static PrtObj p = new PrtObj();
	static int iStart;

	public RunsThreadExample( int iStart ) {
		this.iStart = iStart;
	}

/* overrides Thread.run() It runs anytime the thread is started */
	public void run()  {

		for (int i = iStart; i >= 0; i--)  {
			p.prtln("T minus " + i + " seconds");
			try  {
				Thread.sleep(1000);
			}
			catch (InterruptedException ie)  {
			}
		}
	}
}
