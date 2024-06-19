// LB 308, book 3, chapter 5
// illustrates events and listeners
import utilities.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowsInterface   {

	public static void main(String args[])   {
		// create a timer that calls a Ticker(instance).actionPerformed at one second intervals
		Timer tSec = new Timer(1000, new Ticker());
		tSec.start();

		// display a message box to prevent the program from ending immediately
		JOptionPane.showMessageDialog(null, "Click OK or Exit Program");
	}
}

class Ticker implements ActionListener  {  // ActionListener is an interface

	private boolean bTick = true;

	public void actionPerformed(ActionEvent event)  {
		if (bTick)
			Prt.prtln("Tick...");
		else
			Prt.prtln("Tock...");

        System.out.println(event.getSource()); ////
		bTick = !bTick;
	}
}
