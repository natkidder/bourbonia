// LB 456, book 5, chapter 1
import utilities.PrtObj;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorExample   {
	private static PrtObj p = new PrtObj();

	public static void main(String[] args)   {
		ScheduledThreadPoolExecutor stpePool = new ScheduledThreadPoolExecutor(25);

		Runnable runFlood, runIgnition, runLiftoff;

		runFlood = new LaunchEventNew("Flood the pad!");
		runIgnition = new LaunchEventNew("Start engines!");
		runLiftoff = new LaunchEventNew("Liftoff!");

		for (int iMinus = 20; iMinus >= 0; iMinus--)   {
			Runnable cdcn = new CountDownClockNew( iMinus );
			//stpePool.schedule( new CountDownClockNew( iMinus ), (long)(20 - iMinus), TimeUnit.SECONDS);
			stpePool.schedule( cdcn, (long)( 20 - iMinus), TimeUnit.SECONDS);
		}

		stpePool.schedule(runFlood, 3L, TimeUnit.SECONDS);
		stpePool.schedule(runIgnition, 13L, TimeUnit.SECONDS);
		stpePool.schedule(runLiftoff, 19L, TimeUnit.SECONDS);
		stpePool.shutdown();
	}
}

/* both events and handlers implement Runnable rather than extend Thread */
class CountDownClockNew implements Runnable {
	int iMinus;
	static PrtObj p = new PrtObj();

	public CountDownClockNew( int iMinus )  {
		this.iMinus = iMinus;
	}
	public void run()   {
		p.prtln("T minus " + this.iMinus);
	}
}

class LaunchEventNew implements Runnable  {
	private String sMsg;
	static PrtObj p = new PrtObj();

	public LaunchEventNew( String sMsg )  {
		this.sMsg = sMsg;
	}
    public void run()    {
		p.prtln(sMsg);
	}
}
