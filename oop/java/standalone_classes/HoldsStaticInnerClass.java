// LB 339, book 3, chapter 7
import java.awt.event.*;
import javax.swing.*;
import utilities.*;

public class HoldsStaticInnerClass  {

/* because they will be used by a static inner class, these variables must be declared using static */
	private static String tickMsg = "Tick...";
	private static String tockMsg = "Tock...";

	public static void main(String args[])  {
		PrtObj p = new PrtObj();

		HoldsStaticInnerClass hsic = new HoldsStaticInnerClass();
		hsic.go();
	}

	private void go()  {
/* create a timer that call the StaticInnerClass at one-second intervals */
		Timer t = new Timer( 1000, new StaticInnerClass() );
		t.start();
/* display a message box to prevent the program from ending immediately */
		JOptionPane.showMessageDialog( null, "Click OK to exit program" );
		System.exit(0);
	}

// NOTE the static here, but it seems to make no difference

	static class StaticInnerClass implements ActionListener  {

		private boolean bTick = true;

		public void actionPerformed( ActionEvent aeTick )  {
			PrtObj p = new PrtObj();
			if (bTick)
				System.out.println( tickMsg );
			else
				p.prtln( tockMsg );
			bTick = !bTick;
		}
	}
}

