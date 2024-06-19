// LB 564, Book 6, Chapter 3
/* uses a text field that expects an integer and validates the values */

import javax.swing.*;
import java.awt.event.*;

public class TextFieldValidation extends JFrame  {

	JButton jbtnMain;
	JTextField jtfMain;
	JLabel jlResult;

	public static void main(String args[])   {
		new TextFieldValidation();
	}

	public TextFieldValidation()  {
		this.setSize( 200, 300);
		this.setTitle("Validates A Data Type");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		JPanel jpMain = new JPanel();

		ButtonListener bl = new ButtonListener();

		JLabel jlMain = new JLabel("Enter an Integer");
		jpMain.add(jlMain);

		jtfMain = new JTextField(10);
		jpMain.add(jtfMain);

		jbtnMain = new JButton("Press to Validate");
		jbtnMain.addActionListener(bl);
		jpMain.add(jbtnMain);

		jlResult = new JLabel("");
		jpMain.add(jlResult);

		this.add(jpMain);
		this.setVisible(true);
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed( ActionEvent ae )  {
			try {
				if ( ae.getSource() == jbtnMain )  {
					String Entered = jtfMain.getText();
					int iValidate = Integer.parseInt(Entered);
					jlResult.setText("You entered " + Entered);
				}
			}
			catch ( NumberFormatException nfe )   {
				jlResult.setText("You must enter an integer");
				jtfMain.setText("");
				jtfMain.requestFocus();
			}
		}
	}
}
