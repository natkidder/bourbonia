// LB 583, Book 6, Chapter 3
/* illustrates slider*/

import javax.swing.*;
import java.awt.event.*;

public class ListExample extends JFrame  {

	JButton btnOK;
	JList listMain;
	JLabel lblResult;

	public static void main( String[] args )  {
		new ListExample();
	}

	public ListExample()  {
		this.setSize( 500, 200 );
		this.setTitle("Select an National League City c. 1911");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		ButtonListener bl = new ButtonListener();
		ListListener ll = new ListListener();
		String[] AL = {"Boston", "New York", "Brooklyn", "Philadelphia", "Pittsburgh", "Cincinnatti", "Chicago", "St. Louis"};

		JPanel jpMain = new JPanel();
		JPanel jpList = new JPanel();
		JPanel jpBtn = new JPanel();
		JPanel jpLbl = new JPanel();

		listMain = new JList(AL);
		//cboMain.removeAllItems();   // commented out as it would remove the array
		//listMain.addActionListener(ll);
		listMain.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
		JScrollPane jspMain	= new JScrollPane(listMain,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		//jpList.add( listMain );
		jpList.add( jspMain );
		jpMain.add( jpList);

		btnOK = new JButton("OK");
		btnOK.addActionListener(bl);
		jpBtn.add(btnOK);
		jpMain.add( jpBtn );

		lblResult = new JLabel("");
		jpLbl.add(lblResult);
		jpMain.add( jpLbl );

		this.add( jpMain );
		this.setVisible( true );
	}

	private class ButtonListener implements ActionListener  {
		String Result = "";
		public void actionPerformed( ActionEvent ae )  {
			if ( ae.getSource() == btnOK )  {
				Object[] oResults = listMain.getSelectedValues();
				for ( Object oResult : oResults )
					Result += oResult.toString() + "  ";
				lblResult.setText( "You selected:  " + Result );
			}
		}
	}

	private class ListListener implements ActionListener  {
		public void actionPerformed( ActionEvent ae )  {
			if ( ae.getSource() == listMain )  {
			}
		}
	}
}
