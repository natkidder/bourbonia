// LB 465, book 5, chapter 1
import utilities.*;
import java.util.ArrayList;

public class ThreadWithAbort   {
	public static void main(String[] args)  {

		CountDownClock thrClock = new CountDownClock(20);

		ArrayList<Runnable> runEvents = new ArrayList<Runnable>();

		runEvents.add( new LaunchEvent( 16, "Flood the pad!", thrClock) );
		runEvents.add( new LaunchEvent( 6, "Start engines!", thrClock) );
		runEvents.add( new LaunchEvent( 0, "Liftoff!", thrClock) );

		thrClock.start();

		for ( Runnable runEvent : runEvents )
			new Thread(runEvent).start();
	}
}

/* 'time' here means how many seconds before liftoff */
interface TimeMonitor  {
	int getTime();
	void abortCountDown();
}

class CountDownClock  extends Thread   implements TimeMonitor  {
	static PrtObj p = new PrtObj();
	private int iMinus;

	public CountDownClock( int iMinus )  {
		this.iMinus = iMinus;
	}

	public void run()   {
		boolean bAborted = false;
		for ( ; iMinus >= 0; iMinus--)  {
			p.prtln("T minus " + iMinus);
			try  {
				Thread.sleep(1000);
			}
			catch ( InterruptedException ie )  {
				bAborted = true;
			}
			if ( Thread.interrupted() )
				bAborted = true;
			if ( bAborted )  {
				p.prtln("Stopping the clock!");
				break;
			}
		}
	}

	public int getTime()  {
		return iMinus;
	}

	public synchronized void abortCountDown()  {

		Thread[] thrActives = new Thread[Thread.activeCount()];
		Thread.enumerate(thrActives);

		for (Thread thrCurr : thrActives)
			thrCurr.interrupt();
	}
}

class LaunchEvent implements Runnable  {
	static PrtObj p = new PrtObj();
	private int iStart;
	private String sMsg;
	TimeMonitor tm;

	public LaunchEvent( int iStart, String sMsg, TimeMonitor tm )  {
		this.iStart = iStart;
		this.sMsg = sMsg;
		this.tm = tm;
	}

	public void run()   {
		boolean bEventDone = false;
		boolean bAborted = false;
		while( !bEventDone )  {
			try  {
				Thread.sleep(10);
			}
			catch ( InterruptedException ie )   {
				bAborted = true;
			}
			if ( tm.getTime() <= iStart )  {
				p.prtln( this.sMsg );
				bEventDone = true;
				p.prtln("ABORT!!!");
				tm.abortCountDown();
			}
			if ( Thread.interrupted() )   {
				bAborted = true;
			}
			if ( bAborted )  {
				p.prtln("Aborting " + sMsg);
				break;
			}
		}
	}
}
