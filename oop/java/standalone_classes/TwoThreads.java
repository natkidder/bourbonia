// LB 459, book 5, chapter 1
import utilities.PrtObj;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TwoThreads   {
	private static PrtObj p = new PrtObj();

	static ScheduledThreadPoolExecutor stpePool = new ScheduledThreadPoolExecutor(2);
	static CountDownClass thrClock1 = new CountDownClass(1);
	static CountDownClass thrClock2 = new CountDownClass(2);

	public static void main(String[] args)   {

		doTwoThings();
	}

	static void doTwoThings()  {
		stpePool.execute(thrClock1);
		stpePool.execute(thrClock2);
		stpePool.shutdown();
	}
}


