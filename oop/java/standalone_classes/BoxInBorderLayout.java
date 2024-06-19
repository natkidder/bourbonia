// LB 612, Book 6, Chapter 5
/* Illustrates incorporating the box layout into a border layout */

import javax.swing.*;
//import java.awt.event.*;
import java.awt.*;

public class BoxInBorderLayout extends JFrame   {

	public static void main( String[] args )  {
		new BoxInBorderLayout();
	}

	public BoxInBorderLayout()  {
		this.setSize( 400, 400 );
		this.setTitle("Box Layout inside a Border Layout");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		JPanel pnlBorder = new JPanel();
		pnlBorder.setLayout( new BorderLayout() );

		Box BoxSouth = Box.createHorizontalBox();

		JButton btnAccept = new JButton("Accept");
		JButton btnReject = new JButton("Reject");
		JButton btnClose  = new JButton("Close");

		BoxSouth.add( Box.createRigidArea( new Dimension(20, 40 ) ) );
		BoxSouth.add( btnAccept );
		BoxSouth.add( Box.createHorizontalStrut( 20 ) );
		BoxSouth.add( btnReject );
		BoxSouth.add( Box.createHorizontalGlue() );
		BoxSouth.add( btnClose );
		BoxSouth.add( Box.createHorizontalStrut( 20 ) );

		pnlBorder.add( BoxSouth, BorderLayout.SOUTH );

		this.add( pnlBorder );
		this.setVisible( true );

	}
}
