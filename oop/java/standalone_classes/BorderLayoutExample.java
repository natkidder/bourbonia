// LB 610, Book 6, Chapter 5
/* illustrates border layout */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Dimension;

public class BorderLayoutExample extends JFrame {

	JButton btnMain;
	JLabel lblMain;

	public static void main(String[] args)  {
		new BorderLayoutExample();
	}

	public BorderLayoutExample()  {
		this.setSize( 300, 400 );
		this.setTitle( "Exemplifies Border Layouts" );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		ButtonListener bl = new ButtonListener();
		Dimension d = new Dimension( 50, 30 );

		JPanel jpMain = new JPanel();
		jpMain.setLayout( new BorderLayout( 5, 5 ) );

		btnMain = new JButton("OK");
		btnMain.addActionListener(bl);
		btnMain.setMaximumSize(d);
		jpMain.add(btnMain, BorderLayout.NORTH );

		lblMain = new JLabel("");
		jpMain.add(lblMain, BorderLayout.EAST );

		this.add( jpMain );
		this.setVisible( true );
	}

	private class ButtonListener implements ActionListener  {
		public void actionPerformed( ActionEvent ae )   {
			if ( ae.getSource() == btnMain )  {
				lblMain.setText( "btnMain pushed" );
			}
		}
	}
}


