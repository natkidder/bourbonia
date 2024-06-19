// LB 453, book 5, chapter 1
import utilities.PrtObj;
import java.util.*;

public class ThreadsWorkingTogether   {
	private static PrtObj p = new PrtObj();

	public static void main(String arg[])  {

		CountDownClock thrClock = new CountDownClock(20);

		ArrayList<Runnable> runEvents = new ArrayList<Runnable>();
		runEvents.add( new LaunchEvent( 16, "Flood the pad!", thrClock ) );
		runEvents.add( new LaunchEvent( 6, "Start Engines!", thrClock ) );
		runEvents.add( new LaunchEvent( 0, "Liftoff!", thrClock ) );

		thrClock.start();

// have the threads, one for each launch milestone, run sequentially
		for (Runnable runEvnt : runEvents)
			new Thread(runEvnt).start();
	}
}

interface TimeMonitor  {
	int getTime();
}

class CountDownClock extends Thread implements TimeMonitor           {
	private int iTime;
	static PrtObj p = new PrtObj();

	public CountDownClock( int iStart )  {
		this.iTime = iStart;
	}

	public void run()  {
		for ( ; iTime > 0 ; iTime-- )  {
			p.prtln("T minus " + iTime);
			try  {
//				p.prtln("Thread CountDownClock.run running");////
				Thread.sleep(1000);
			}
			catch (InterruptedException ie)  {
			}
		}
	}
	public int getTime()  {
		return iTime;
	}
}

class LaunchEvent implements Runnable  {
	static PrtObj p = new PrtObj();
	private int iStart;
	private String sMsg;
	TimeMonitor tm;

	public LaunchEvent( int iStart, String sMsg, TimeMonitor tmMonitor )  {
//		p.prtln("runnable LaunchEvent constructing"); ////
		this.iStart = iStart;
		this.sMsg = sMsg;
		this.tm = tmMonitor;
	}

/* this runs whenever the thread starts */
	public void run()  {
//		p.prtln("runnable LaunchEvent.run running"); ////
		boolean bEventDone = false;

		while ( !bEventDone )  {
			try  {
				Thread.sleep(10);
			}
			catch ( InterruptedException ie )  {
			}
//			p.prtln( "tm.getTime() = " + tm.getTime() + ", iStart = " + iStart ); ////
			if ( tm.getTime() <= iStart ) {
				p.prtln(this.sMsg);
				bEventDone = true;
			}
		}
	}
}
