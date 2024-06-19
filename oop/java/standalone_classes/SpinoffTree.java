// LB 604, Book 6, Chapter 4
/* illustrates a spinner*/

import javax.swing.*;
import java.awt.event.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class SpinoffTree extends JFrame  {

	public static void main(String[] args)  {
		new SpinoffTree();
	}

	private JTree treeMain;
	private DefaultTreeModel dtmMain;
	private JLabel lblName;

	public SpinoffTree()   {
		this.setSize( 300, 325);
		this.setTitle( "Famous Spinoffs" );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		JPanel jpMain = new JPanel();

		DefaultMutableTreeNode dmtnRoot, dmtnAndy, dmtnArchie, dmtnHappy, dmtnGeorge, dmtnMaude;

		dmtnRoot = new DefaultMutableTreeNode( "Famous Spinoffs");

		dmtnAndy = makeShow( "The Andy Griffith Show", dmtnRoot );
		makeShow( "Gomer Pyle, USMC", dmtnAndy );
		makeShow( "Mayberry, RFD", dmtnAndy );

		dmtnArchie = makeShow( "All In the Family", dmtnRoot );
		dmtnGeorge = makeShow( "The Jeffersons", dmtnArchie );
		makeShow( "Checking In", dmtnGeorge );
		dmtnMaude = makeShow( "Maude", dmtnArchie );
		makeShow( "Good Times", dmtnMaude );
		makeShow( "Gloria", dmtnArchie );
		makeShow( "Archie Bunker's Place", dmtnArchie );

		dmtnHappy = makeShow( "Happy Days", dmtnRoot );
		makeShow( "Mork and Mindy", dmtnHappy );
		makeShow( "Laverne and Shirley", dmtnHappy);
		makeShow( "Joanie Loves Chachi", dmtnHappy);

		treeMain = new JTree( dmtnRoot );
		treeMain.getSelectionModel().setSelectionMode( TreeSelectionModel.SINGLE_TREE_SELECTION );
		treeMain.setVisibleRowCount( 12 );
		treeMain.addTreeSelectionListener( new TreeListener() );

		JScrollPane jspMain = new JScrollPane( treeMain );
		jpMain.add( jspMain );

		lblName = new JLabel();
		jpMain.add( lblName );
		this.add( jpMain );
		this.setVisible( true );
	}

	private DefaultMutableTreeNode makeShow( String title, DefaultMutableTreeNode dmtnParent )  {
		DefaultMutableTreeNode dmtnShow;
		dmtnShow = new DefaultMutableTreeNode( title );
		dmtnParent.add( dmtnShow );
		return dmtnShow;
	}

	private class TreeListener implements TreeSelectionListener  {
		public void valueChanged( TreeSelectionEvent tse )  {
			Object oSelected = treeMain.getLastSelectedPathComponent();
			DefaultMutableTreeNode dmtnShow;
			dmtnShow = (DefaultMutableTreeNode)oSelected;
			String title = (String)dmtnShow.getUserObject();
			lblName.setText( title );
		}
	}
}
