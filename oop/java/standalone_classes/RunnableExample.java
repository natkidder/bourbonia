// LB 449, book 5, chapter 1
import utilities.PrtObj;
import java.util.*;

public class RunnableExample   {
	private static PrtObj p = new PrtObj();

	public static void main(String arg[])  {

		Thread thrClock = new RunsThreadExample();

		Runnable irFlood, irIgnition, irLiftoff;

		irFlood = new ImplementsRunnable( 16, "Flood the pad!" );
		irIgnition = new ImplementsRunnable( 6, "Start engines!" );
		irLiftoff = new ImplementsRunnable( 0, "Liftoff!" );

		thrClock.start();

		new Thread(irFlood).start();
		new Thread(irIgnition).start();
		new Thread(irLiftoff).start();

	}
}

class RunsThreadExample extends Thread  {

	static PrtObj p = new PrtObj();

/* overrides Thread.run() It runs anytime the thread is started */
	public void run()  {

		for (int i = 20; i >= 0; i--)  {
			p.prtln("T minus " + i + " seconds");
			try  {
				Thread.sleep(1000);
			}
			catch (InterruptedException ie)  {
			}
		}
	}
}

class ImplementsRunnable implements Runnable  {

	private int iStart;
	private String sMsg;
	private static PrtObj p = new PrtObj();

	public ImplementsRunnable( int iStart, String sMsg )  {
		this.iStart = iStart;
		this.sMsg = sMsg;
	}

	public void run()  {
//		p.prtln("ImplementsRunnable.run running"); ////
		try  {
			Thread.sleep( 20000 - ( iStart * 1000) );
			p.prtln(sMsg);
		}
		catch (InterruptedException ie) {
		}
	}
}
