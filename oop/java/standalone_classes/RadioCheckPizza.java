// LB 577, Book 6, Chapter 3
/* illustrates radio buttons & check boxes in one pizza ordering program*/

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class RadioCheckPizza extends JFrame   {

	public static void main(String[] args)  {
		new RadioCheckPizza();
	}

	private JButton jbtnOK;
	private JRadioButton rbSmall, rbMedium, rbLarge;
	private JCheckBox jcbPepperoni, jcbMushrooms, jcbAnchovies;

	public RadioCheckPizza()   {
		this.setSize( 320, 200 );
		this.setTitle( "Order Your Pizza" );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		ButtonListener bl = new ButtonListener();

		JPanel jpMain = new JPanel();
		JPanel jpSize = new JPanel();
		JPanel jpTop = new JPanel();

		Border borderSize = BorderFactory.createTitledBorder("Size");
		jpSize.setBorder(borderSize);

		ButtonGroup bgSize = new ButtonGroup();

		rbSmall = new JRadioButton("Small");
		rbSmall.setSelected(true);
		bgSize.add(rbSmall);
		jpSize.add(rbSmall);

		rbMedium = new JRadioButton("Medium");
		bgSize.add(rbMedium);
		jpSize.add(rbMedium);

		rbLarge = new JRadioButton("Large");
		bgSize.add(rbLarge);
		jpSize.add(rbLarge);

		jpMain.add( jpSize );

		Border borderToppings = BorderFactory.createTitledBorder("Toppings");
		jpTop.setBorder( borderToppings );

		jcbPepperoni = new JCheckBox("Pepperoni");
		jpTop.add( jcbPepperoni );
		jcbMushrooms = new JCheckBox("Mushrooms");
		jpTop.add( jcbMushrooms );
		jcbAnchovies = new JCheckBox("Anchovies");
		jpTop.add( jcbAnchovies );

		jpMain.add( jpTop );

		jbtnOK = new JButton("OK");
		jbtnOK.addActionListener(bl);
		jpMain.add( jbtnOK );

		this.add( jpMain );
		this.setVisible( true );
	}

	private class ButtonListener implements ActionListener  {

		public void actionPerformed( ActionEvent ae )  {
			if ( ae.getSource() == jbtnOK )  {
				String toppings = "";
				if ( jcbPepperoni.isSelected() )
					toppings += "Pepperoni\n";
				if ( jcbMushrooms.isSelected() )
					toppings += "Mushrooms\n";
				if ( jcbAnchovies.isSelected() )
					toppings += "Anchovies\n";

				String msg = "You ordered a ";
				if ( rbSmall.isSelected() )
					msg += "small pizza with\n";
				else if ( rbMedium.isSelected() )
					msg += "medium pizza with\n";
				else if ( rbLarge.isSelected() )
					msg += "large pizza with\n";

				if ( toppings.equals("") )
					msg += "no toppings";
				else
					msg += toppings;

				JOptionPane.showMessageDialog( jbtnOK, msg, "Your Order",
					JOptionPane.INFORMATION_MESSAGE );

				jcbPepperoni.setSelected( false );
				jcbMushrooms.setSelected( false );
				jcbAnchovies.setSelected( false );
				rbSmall.setSelected( true );
			}
		}
	}
}
