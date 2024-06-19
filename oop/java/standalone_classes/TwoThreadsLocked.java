// LB 462, book 5, chapter 1
import utilities.PrtObj;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class TwoThreadsLocked   {
	private static PrtObj p = new PrtObj();

	static ScheduledThreadPoolExecutor stpePool = new ScheduledThreadPoolExecutor(2);
	static CountDownClockLocked thrClock = new CountDownClockLocked();

	public static void main(String args[])  {
		DoTwoThingsLocked();
	}
	private static void DoTwoThingsLocked()  {
		stpePool.execute(thrClock);
		stpePool.execute(thrClock);
		stpePool.shutdown();
	}
}
