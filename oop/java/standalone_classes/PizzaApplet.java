// LB 634, Book 7, Chapter 1
/* Illustrates applets */

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class PizzaApplet extends JApplet   {

	private JButton btnOK;
	private JRadioButton rbSmall, rbMedium, rbLarge;
	private JCheckBox cbPepperoni, cbMushrooms, cbAnchovies;

	public void init()   {    // applets use init, not main
		this.setSize( 320, 200 );

		GenericListener gl = new GenericListener();

		JPanel pnlMain = new JPanel();

		JPanel pnlSize = new JPanel();
		Border borderSize = BorderFactory.createTitledBorder( "Size" );
		pnlSize.setBorder( borderSize );

		ButtonGroup bgSize = new ButtonGroup();

		rbSmall = new JRadioButton( "Small" );
		rbSmall.setSelected( true );
		bgSize.add( rbSmall );
		pnlSize.add( rbSmall );
		rbMedium = new JRadioButton( "Medium" );
		bgSize.add( rbMedium );
		pnlSize.add( rbMedium );
		rbLarge = new JRadioButton( "Large" );
		bgSize.add( rbLarge );
		pnlSize.add( rbLarge );
		pnlMain.add( pnlSize );

		JPanel pnlToppings = new JPanel();
		Border borderToppings = BorderFactory.createTitledBorder( "Toppings" );
		pnlToppings.setBorder( borderToppings );
		cbPepperoni = new JCheckBox( "Pepperoni" );
		pnlToppings.add( cbPepperoni );
		cbMushrooms = new JCheckBox( "Mushrooms" );
		pnlToppings.add( cbMushrooms );
		cbAnchovies = new JCheckBox( "Anchovies" );
		pnlToppings.add( cbAnchovies );
		pnlMain.add( pnlToppings );

		btnOK = new JButton( "OK" );
		btnOK.addActionListener( gl );
		pnlMain.add( btnOK );

		this.add( pnlMain );
		this.setVisible( true );
	}

	private class GenericListener implements ActionListener   {
		public void actionPerformed( ActionEvent ae )  {
			if ( ae.getSource() == btnOK )  {
				String toppings = "";
				if ( cbPepperoni.isSelected() )
					toppings += "Pepperoni\n";
				if ( cbMushrooms.isSelected() )
					toppings += "Mushrooms\n";
				if ( cbAnchovies.isSelected() )
					toppings += "Anchovies\n";

				String msg = "You ordered a ";
				if ( rbSmall.isSelected() )  {
					msg += "small pizza with ";
				} else if ( rbMedium.isSelected() ) {
					msg += "medium pizza with ";
				} else {
					msg += "large pizza with ";
				}

				if ( toppings.equals( "" ) )
					msg += "no toppings.";
				else
					msg += "the following toppings\n" + toppings;

				JOptionPane.showMessageDialog( btnOK, msg, "Your Order", JOptionPane.INFORMATION_MESSAGE );

				cbPepperoni.setSelected( false );
				cbMushrooms.setSelected( false );
				cbAnchovies.setSelected( false );
				rbSmall.setSelected( true );
			}
		}
	}
}

