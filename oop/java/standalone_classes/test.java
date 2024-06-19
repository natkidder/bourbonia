// LB 583, Book 6, Chapter 3
/* illustrates slider*/

import javax.swing.*;
import java.awt.event.*;

public class ComboExample extends JFrame  {

	JButton btnOK;
	JComboBox cboMain;
	JLabel lblResult;

	public static void main( String[] args )  {
		new ComboExample();
	}

	public ComboExample()  {
		this.setSize( 500, 200 );
		this.setTitle("");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		ButtonListener bl = new ButtonListener();
		String[] AL = {"Boston", "New York", "Philadelphia", "Washington", "Cleveland", "Detroit", "Chicago", "St. Louis"};

		JPanel jpMain = new JPanel();
		JPanel jpCombo = new JPanel();
		JPanel jpBtn = new JPanel();
		JPanel jpLbl = new JPanel();

		cboMain = new JComboBox(AL);
		cboMain.removeItem("St. Louis");
		cboMain.addItem("Baltimore");
		cboMain.removeItem("Philadelphia");
		cboMain.addItem("Kansas City");
		jpCombo.add( cboMain );
		jpMain.add( jpSlider);

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
				lblResult.setText( "You selected " + Result );
			}
		}
	}

}
