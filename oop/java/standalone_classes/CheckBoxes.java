// LB 566, Book 6, Chapter 3
/* illustrates check boxes */

import javax.swing.*;
import java.awt.event.*;

public class CheckBoxes extends JFrame  {

	JCheckBox jcbPepperoni, jcbMushrooms, jcbAnchovies;
	JButton jbtnMain;
	JLabel jlMain;

	public static void main(String args[])   {
		new CheckBoxes();
	}

	public CheckBoxes() {
		this.setSize( 500, 300);
		this.setTitle("Check all the toppings you want");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		JPanel jpMain = new JPanel();

		ButtonListener bl = new ButtonListener();

		jcbPepperoni = new JCheckBox("Pepperoni", true);
		jcbMushrooms = new JCheckBox("Mushrooms", false);
		jcbAnchovies = new JCheckBox("Anchovies", false);
		jpMain.add(jcbPepperoni);
		jpMain.add(jcbMushrooms);
		jpMain.add(jcbAnchovies);

		jbtnMain = new JButton("Click to Order");
		jbtnMain.addActionListener(bl);
		jpMain.add(jbtnMain);

		jlMain = new JLabel();
		jpMain.add(jlMain);

		this.add(jpMain);
		this.setVisible(true);
	}

	private class ButtonListener implements ActionListener  {

		private String ToppingsOrdered;

		public void actionPerformed( ActionEvent ae )  {
			if ( ae.getSource() == jbtnMain )   {
				ToppingsOrdered = "";
				if ( jcbPepperoni.isSelected() )
					ToppingsOrdered += "Pepperoni ";
				if ( jcbMushrooms.isSelected() )
					ToppingsOrdered += "Mushrooms ";
				if ( jcbAnchovies.isSelected() )
					ToppingsOrdered += "Anchovies ";
				if ( ToppingsOrdered.length() == 0 )
					ToppingsOrdered = "Nothing";
				jlMain.setText( "You ordered: " + ToppingsOrdered );
			}
		}
	}
}

