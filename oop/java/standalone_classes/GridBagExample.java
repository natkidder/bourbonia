// LB 621, Book 6, Chapter 6
/* example of a GridBag Layout */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GridBagExample extends JFrame   {

	public static void main(String args[])  {
		new GridBagExample();
	}

	JTextField tfName, tfPhone, tfAddress;
	JRadioButton rbSmall, rbMedium, rbLarge, rbThick, rbThin;
	JCheckBox cbPepperoni, cbMushrooms, cbAnchovies;
	JButton btnOK, btnClose;
	JLabel lblMain;

	public GridBagExample()   {
		this.setTitle( "Pizza Order" );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		JPanel pnlMain = new JPanel();
		pnlMain.setLayout( new GridBagLayout() );

		addItem( pnlMain, new JLabel("Name:"), 0, 0, 1, 1, GridBagConstraints.EAST );
		addItem( pnlMain, new JLabel("Phone:"), 0, 1, 1, 1, GridBagConstraints.EAST );
		addItem( pnlMain, new JLabel("Address:"), 0, 2, 1, 1, GridBagConstraints.EAST );

		tfName = new JTextField( 20 );
		tfPhone = new JTextField( 10 );
		tfAddress = new JTextField( 20 );

		addItem( pnlMain, tfName, 1, 0, 2, 1, GridBagConstraints.WEST );
		addItem( pnlMain, tfPhone, 1, 1, 1, 1, GridBagConstraints.WEST );
		addItem( pnlMain, tfAddress, 1, 2, 2, 1, GridBagConstraints.WEST );

		Box boxSize = Box.createVerticalBox();
		rbSmall = new JRadioButton( "Small" );
		rbMedium = new JRadioButton( "Medium" );
		rbLarge = new JRadioButton( "Large" );
		ButtonGroup bgSize = new ButtonGroup();
		bgSize.add( rbSmall );
		bgSize.add( rbMedium );
		bgSize.add( rbLarge );
		boxSize.add( rbSmall );
		boxSize.add( rbMedium );
		boxSize.add( rbLarge );
		boxSize.setBorder( BorderFactory.createTitledBorder( "Size" ) );
		addItem( pnlMain, boxSize, 0, 3, 1, 1, GridBagConstraints.NORTH );

		Box boxStyle = Box.createVerticalBox();
		rbThin = new JRadioButton( "Thin" );
		rbThick = new JRadioButton( "Thick" );
		ButtonGroup bgStyle = new ButtonGroup();
		bgStyle.add( rbThin );
		bgStyle.add( rbThick );
		boxStyle.add( rbThin );
		boxStyle.add( rbThick );
		boxStyle.setBorder( BorderFactory.createTitledBorder( "Style" ) );
		addItem( pnlMain, boxStyle, 1, 3, 1, 1, GridBagConstraints.NORTH );

		Box boxToppings = Box.createVerticalBox();
		cbPepperoni = new JCheckBox( "Pepperoni" );
		cbMushrooms = new JCheckBox( "Mushrooms" );
		cbAnchovies = new JCheckBox( "Anchovies" );
		ButtonGroup bgToppings = new ButtonGroup();  // ButtonGroup for checkboxes?
		bgToppings.add( cbPepperoni );
		bgToppings.add( cbMushrooms );
		bgToppings.add( cbAnchovies );
		boxToppings.add( cbPepperoni );
		boxToppings.add( cbMushrooms );
		boxToppings.add( cbAnchovies );
		boxToppings.setBorder( BorderFactory.createTitledBorder( "Toppings" ) );
		addItem( pnlMain, boxToppings, 2, 4, 1, 1, GridBagConstraints.NORTH );

		Box boxButtons = Box.createVerticalBox();
		GenericListener gl = new GenericListener();
		btnOK = new JButton( "OK" );
		btnOK.addActionListener(gl);
		btnClose = new JButton( "Close" );
		btnClose.addActionListener(gl);
		lblMain = new JLabel("");
		boxButtons.createRigidArea( new Dimension( 20, 20 ) );
		boxButtons.add( btnOK );
		boxButtons.createVerticalStrut( 40 );    //does not seem to work
		boxButtons.add( btnClose );
		boxButtons.add( Box.createVerticalGlue() );
		boxButtons.add( lblMain );
		addItem( pnlMain, boxButtons, 1, 4, 1, 2, GridBagConstraints.NORTH );

		this.add( pnlMain );
		this.pack();
		this.setVisible( true );
	}

	private void addItem( JPanel pnl, JComponent component, int x, int y, int width, int height, int iAlign )  {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = 100.0;     // not sure what the significance of 100 is
		gbc.weighty = 100.0;
		gbc.insets = new Insets( 5, 5, 5, 5 );
		gbc.anchor = iAlign;
		gbc.fill = GridBagConstraints.NONE;
		pnl.add( component, gbc );
	}

	private class GenericListener implements ActionListener  {
		public void actionPerformed( ActionEvent ae )  {
			if ( ae.getSource() == btnOK )  {
				lblMain.setText( "Ordered" );
			} else if ( ae.getSource() == btnClose )   {
				System.exit(0);
			}
		}
	}
}
