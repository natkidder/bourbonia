// LB 462, book 5, chapter 1
import java.util.concurrent.locks.ReentrantLock;

public class CountDownClockLocked extends Thread  {

	ReentrantLock reLock = new ReentrantLock();
	boolean bAbort = false;

	public void run()  {

		reLock.lock();  //locks the thread, preventing others from using it

		for ( int iMinus = 10; iMinus >= 0; iMinus-- )  {
			System.out.println("T minus " + iMinus);
			try  {
				Thread.sleep(1000);
				if (iMinus <= 4)   {
					this.interrupt();  ///// does not seem to work
				}
			}
			catch (InterruptedException ie)  {
				bAbort = true;
			}
			if ( Thread.interrupted() )   {
				System.out.println("Thread interrupted");
				bAbort = true;
			}
			if (bAbort)  {
				reLock.unlock();
				break;
			}
		}
		reLock.unlock();  // releases the thread for other processes to use it
	}
}
