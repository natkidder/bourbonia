// LB 615, Book 6, Chapter 5
/* illustrates Grid layout */

import javax.swing.*;
//import java.awt.event.*;
import java.awt.*;

public class GridLayoutExample extends JFrame   {

	public static void main( String args[] )  {
		new GridLayoutExample( 400, 400 );
	}

	public GridLayoutExample( int iWidth, int iHeight )   {
		this.setSize( iWidth, iHeight );
		this.setTitle( "Grid Layout -- Hollywood Squares" );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		JPanel pnlMain = new JPanel();
		JPanel pnlGrid = new JPanel();
		pnlGrid.setLayout( new GridLayout( 3, 3, 20, 20 ) );  // 3 rows and 3 columns, with horiz & vert gaps of 20

		JButton btn11 = new JButton( "Don Rickles" );
		JButton btn12 = new JButton( "Goldie Hawn" );
		JButton btn13 = new JButton( "Bill Daily" );
		JButton btn21 = new JButton( "Lilly Tomlin" );
		JButton btn22 = new JButton( "Paul Lynn" );
		JButton btn23 = new JButton( "Bob Newhart" );
		JButton btn31 = new JButton( "Ted Knight" );
		JButton btn32 = new JButton( "Flip Wilson" );
		JButton btn33 = new JButton( "Tina Louise" );

		pnlGrid.add( btn11 );
		pnlGrid.add( btn12 );
		pnlGrid.add( btn13 );
		pnlGrid.add( btn21 );
		pnlGrid.add( btn22 );
		pnlGrid.add( btn23 );
		pnlGrid.add( btn31 );
		pnlGrid.add( btn32 );
		pnlGrid.add( btn33 );

		this.add( pnlGrid );
		this.setVisible( true );
	}
}
