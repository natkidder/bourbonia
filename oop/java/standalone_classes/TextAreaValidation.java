// LB 566, Book 6, Chapter 3
/* uses a text field that expects an integer and validates the values */

import javax.swing.*;
import java.awt.event.*;

public class TextAreaValidation extends JFrame  {

	JButton jbtnMain;
	JTextArea jtaMain;
	JLabel jlResult;
	JScrollPane jspMain;

	public static void main(String args[])   {
		new TextAreaValidation();
	}

	public TextAreaValidation()  {
		this.setSize( 300, 400);
		this.setTitle("Validates A Text Area");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		JPanel jpMain = new JPanel();

		ButtonListener bl = new ButtonListener();

		JLabel jlMain = new JLabel("Enter <LastName>, <FirstName>");
		jpMain.add(jlMain);

		jtaMain = new JTextArea(5, 20);
		jtaMain.setLineWrap( true );
		jtaMain.setWrapStyleWord( true );
		jspMain = new JScrollPane( jtaMain,
		                   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		                   JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		jpMain.add(jspMain);

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
					String Entered = jtaMain.getText();
					if ( Entered.matches("^.*,.*$") )  {
						jlResult.setText("You entered " + Entered);
					} else {
						jlResult.setText("Please enter <LastName>, <FirstName>");
						jtaMain.setText("");
						jtaMain.requestFocus();
					}
				}
			}
			catch ( Exception e )   {
				e.printStackTrace();
			}
		}
	}
}
