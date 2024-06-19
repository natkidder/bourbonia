// LB 343, book 3, chapter 7
import java.awt.event.*;
import javax.swing.*;
import utilities.*;

public class HoldsAnonymousClass  {

/* because they will be used by a static inner class, these variables must be declared using static */
	private static String tickMsg = "Tick...";
	private static String tockMsg = "Tock...";

	public static void main(String args[])  {
		HoldsAnonymousClass hac = new HoldsAnonymousClass();
		hac.go();
	}

	private void go()  {

		Timer t = new Timer( 1000, // start the anonymous class (drpp the boundary and the class name)
			new ActionListener()  {
				private boolean bTick = true;
				private PrtObj p = new PrtObj();
				public void actionPerformed( ActionEvent event)  {
					if (bTick)
						p.prtln(tickMsg);
					else
						p.prtln(tockMsg);
					bTick = !bTick;
				}
			} ); // close the Timer parameters

		t.start();

/* display a message box to prevent the program from ending immediately */
		JOptionPane.showMessageDialog( null, "Click OK to exit program" );
		System.exit(0);
	}
}
