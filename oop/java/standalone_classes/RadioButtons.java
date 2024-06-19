// LB 576, Book 6, Chapter 3
/* illustrates radio buttons */

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class RadioButtons extends JFrame  {

	JRadioButton jrbSmall, jrbMedium, jrbLarge;
	JButton jbtnMain;
	JLabel jlMain;

	public static void main(String args[])   {
		new RadioButtons();
	}

	public RadioButtons() {
		this.setSize( 300, 300);
		this.setTitle("Select the size");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		JPanel jpMain = new JPanel();
		JPanel jpButtons = new JPanel();

		ButtonListener bl = new ButtonListener();

		jrbSmall = new JRadioButton("Small");
		jrbSmall.setSelected( true );
		jrbMedium = new JRadioButton("Medium");
		jrbLarge = new JRadioButton("Large");

		ButtonGroup bgMain = new ButtonGroup();
		bgMain.add(jrbSmall);
		bgMain.add(jrbMedium);
		bgMain.add(jrbLarge);
		jpButtons.add(jrbSmall);
		jpButtons.add(jrbMedium);
		jpButtons.add(jrbLarge);

		Border borderButtons = BorderFactory.createTitledBorder("Size");
		jpButtons.setBorder( borderButtons );

		jpMain.add( jpButtons );  // have one panel per frame, and add the other panels to it

		jbtnMain = new JButton("Click to Order");
		jbtnMain.addActionListener(bl);
		jpMain.add(jbtnMain);

		jlMain = new JLabel();
		jpMain.add(jlMain);

		this.add(jpMain);
		this.setVisible(true);
	}

	private class ButtonListener implements ActionListener  {

		private String size;

		public void actionPerformed( ActionEvent ae )  {
			if ( ae.getSource() == jbtnMain )   {
				if ( jrbSmall.isSelected() )
					size = "Small";
				else if ( jrbMedium.isSelected() )
					size = "Medium";
				else if ( jrbLarge.isSelected() )
					size = "Large";
				jlMain.setText( "You ordered: " + size );
			}
		}
	}
}

