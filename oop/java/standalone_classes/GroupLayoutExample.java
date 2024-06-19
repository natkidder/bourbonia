// LB 625, Book 6, Chapter 5
/* Illustrates group layout */

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Here, instead of defining and instantiating a JFrame class, you are instantiating a JFrame class inside a plain one
public class GroupLayoutExample  {

	public static void main( String[] args )  {

		JFrame frameMain = new JFrame();
		JPanel pnlMain = new JPanel();
		frameMain.setSize( 400, 400);
		frameMain.setTitle( "Created via GroupLayout 2 Different Ways" );
		frameMain.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// instantiating a GroupLayout and associating it with an instantiated panel
		GroupLayout grpLayoutMain = new GroupLayout( pnlMain );
		pnlMain.setLayout( grpLayoutMain );

		JButton btnD = new JButton( "D" );
		JButton btnR = new JButton( "R" );
		JButton btnY = new JButton( "Y" );
		JButton btnO = new JButton( "O" );
		JButton btnT = new JButton( "T" );

		// add the buttons to the panel one way
		GroupLayout.SequentialGroup sgLeftToRight = grpLayoutMain.createSequentialGroup(); // create a horizontal row
		sgLeftToRight.addComponent( btnD );
		GroupLayout.ParallelGroup pgColumnMiddle = grpLayoutMain.createParallelGroup(); // create a vertical column
		pgColumnMiddle.addComponent( btnR );
		pgColumnMiddle.addComponent( btnO );
		pgColumnMiddle.addComponent( btnT );
		sgLeftToRight.addGroup( pgColumnMiddle );
		sgLeftToRight.addComponent( btnY );

		// add the buttons to the panel another way, with the same result
		GroupLayout.SequentialGroup sgTopToBottom = grpLayoutMain.createSequentialGroup();
		GroupLayout.ParallelGroup pgTopRow = grpLayoutMain.createParallelGroup();
		pgTopRow.addComponent( btnD );
		pgTopRow.addComponent( btnR );
		pgTopRow.addComponent( btnY );
		sgTopToBottom.addGroup( pgTopRow );
		sgTopToBottom.addComponent( btnO );
		sgTopToBottom.addComponent( btnT );

		grpLayoutMain.setHorizontalGroup( sgLeftToRight );
		grpLayoutMain.setVerticalGroup( sgTopToBottom );

		frameMain.add( pnlMain );
		frameMain.pack();
		frameMain.setVisible( true );
	}
}
