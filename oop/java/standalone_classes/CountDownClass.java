// LB 446, book 5, chapter 1
// works with TwoThreads.class

import utilities.*;

class CountDownClass extends Thread  {

	static PrtObj p = new PrtObj();
	static int iThreadNbr;

//the constructor is NOT necessary.  There's always the parameterless default constructor.

	public CountDownClass( int iThreadNbr )  {
		this.iThreadNbr = iThreadNbr;
		this.p.prtln("CountDownClass.iThreadNbr = " + iThreadNbr); ////
	}

/* overrides Thread.run() It runs anytime the thread is started */
	public void run()  {

		for (int i = 10; i >= 0; i--)  {
			p.prtln( this.iThreadNbr + ": T minus " + i + " seconds");
			try  {
				Thread.sleep(1000);
			}
			catch (InterruptedException ie)  {
				p.prtln("I've been interrupted");
			}
		}
		p.prtln( iThreadNbr + ": Liftoff!");
	}
}
