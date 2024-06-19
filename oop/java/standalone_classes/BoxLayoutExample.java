// LB 612, Book 6, Chapter 5
/* illustrates box layout, using the box rather than the JPanel class */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BoxLayoutExample extends JFrame  {

	JButton btnMain;
	JLabel lblMain;

	public static void main( String[] args )  {
		new BoxLayoutExample();
	}

	public BoxLayoutExample()   {
		this.setSize( 400, 400 );
		this.setTitle("Box Layout Using the Box Class");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		GenericListener gl = new GenericListener();

		Box boxMain = Box.createVerticalBox();

		btnMain = new JButton("Click Me");
		btnMain.addActionListener(gl);
		lblMain = new JLabel();

		boxMain.add( Box.createRigidArea( new Dimension( 80, 40 ) ) );
		boxMain.add( btnMain );
		boxMain.add( Box.createVerticalStrut( 20 ) );
		boxMain.add( lblMain );
		boxMain.add( Box.createVerticalStrut( 20 ) );

		this.add( boxMain );
		this.setVisible( true );

	}

	private class GenericListener implements ActionListener  {
		public void actionPerformed( ActionEvent ae )  {
			if ( ae.getSource() == btnMain )  {
				lblMain.setText( "\"I drank what?\" --Socrates");
			}
		}
	}
}
