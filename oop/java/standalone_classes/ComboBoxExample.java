// LB 583, Book 6, Chapter 4
/* illustrates a spinner*/

import javax.swing.*;
import java.awt.event.*;

public class ComboBoxExample extends JFrame  {

	JButton btnOK;
	JComboBox cboMain;
	JLabel lblResult;

	public static void main( String[] args )  {
		new ComboBoxExample();
	}

	public ComboBoxExample()  {
		this.setSize( 500, 200 );
		this.setTitle("Select an American League City c. 1957");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		ButtonListener bl = new ButtonListener();
		ComboListener cl = new ComboListener();
		String[] AL = {"Boston", "New York", "Philadelphia", "Washington", "Cleveland", "Detroit", "Chicago", "St. Louis"};

		JPanel jpMain = new JPanel();
		JPanel jpCombo = new JPanel();
		JPanel jpBtn = new JPanel();
		JPanel jpLbl = new JPanel();

		cboMain = new JComboBox(AL);
		//cboMain.removeAllItems();   // commented out as it would remove the array
		cboMain.removeItem("St. Louis");
		cboMain.addItem("Baltimore");
		cboMain.removeItem("Philadelphia");
		cboMain.addItem("Kansas City");
		cboMain.addActionListener(cl);
		jpCombo.add( cboMain );
		jpMain.add( jpCombo);

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
		public void actionPerformed( ActionEvent ae )  {
			if ( ae.getSource() == btnOK )  {
				String Result = cboMain.getSelectedItem().toString();
				lblResult.setText( "btn: You selected " + Result );
			}
		}
	}

	private class ComboListener implements ActionListener  {
		public void actionPerformed( ActionEvent ae )  {
			if ( ae.getSource() == cboMain )  {
				String Result = (String)cboMain.getSelectedItem();
				lblResult.setText( "Combo Box: You selected " + Result );
			}
		}
	}
}
