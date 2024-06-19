// LB 459, book 5, chapter 1
import utilities.PrtObj;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class TwoThreadsInSync   {
	private static PrtObj p = new PrtObj();

	static ScheduledThreadPoolExecutor stpePool = new ScheduledThreadPoolExecutor(2);
	static CountDownClockSync thrClock = new CountDownClockSync(10);

	public static void main(String args[])  {
		DoTwoThingsSync();
	}

	public static void DoTwoThingsSync()  {
//NOTE: the printing are a separate thread from the countdowns, so they will be printed independently.
		p.prtln("First serial countdown...");
		stpePool.execute(thrClock);
		p.prtln("Second serial countdown...");
		stpePool.execute(thrClock);
		stpePool.shutdown();
	}
}
