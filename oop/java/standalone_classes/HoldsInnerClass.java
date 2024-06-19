// LB 337, book 3, chapter 7
import java.awt.event.*;
import javax.swing.*;
import utilities.*;

public class HoldsInnerClass  {

	private String tickMsg = "Tick...";
	private String tockMsg = "Tock...";

	public static void main(String args[])  {
		PrtObj p = new PrtObj();

//		OuterClassOfInnerClass ocoic = new OuterClassOfInnerClass();
//		ocoic.go();
		HoldsInnerClass hic = new HoldsInnerClass();
		hic.go();
	}

	private void go()  {
/* create a timer that calls the InnerClass class at one-second intervals */
		Timer t = new Timer(1000, new InnerClass() );
		t.start();

/* display a message box to prevent the program from ending immediately */
		JOptionPane.showMessageDialog(null, "Click OK to Exit the Program");
		System.exit(0);
	}

	class InnerClass implements ActionListener  {

		private boolean bTick = true;
		PrtObj p = new PrtObj();

		public void actionPerformed( ActionEvent aeTick )  {
			if (bTick)
				p.prtln(tickMsg);
			else
				p.prtln(tockMsg);
			bTick = !bTick;
		}
	}
}
