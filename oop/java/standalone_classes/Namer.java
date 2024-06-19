// LB 560, Book 6, Chapter 3
/*
A simple program that uses a text field to ask for the user's name. If the user enters a name, the program
uses JOptionPane tosay good morning th the user by displaying a message box.  But if the user clicks the button without
entering anything, the program displays a second JOptionPane message.
*/

import javax.swing.*;
import java.awt.event.*;

public class Namer extends JFrame   {

	public static void main(String[] args)  {
		new Namer();
	}

	// make these class variables so both the constructor and ActionListener can access them
	private JButton jbtnOK;
	private JTextField jtfName;

	public Namer()   {

		this.setSize( 325, 100);
		this.setTitle( "Who are you?");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		ButtonListener BtnListener = new ButtonListener();

		JPanel jpMain = new JPanel();

		// note the anonymous class
		jpMain.add( new JLabel("Enter your name: ") );

		jtfName = new JTextField(15);  // the column width
		jpMain.add( jtfName );

		jbtnOK = new JButton("OK");
		jbtnOK.addActionListener( BtnListener ); // so it can react to events
		jpMain.add( jbtnOK );

		this.add( jpMain );

		this.setVisible( true );
	}

	private class ButtonListener implements ActionListener   {

		public void actionPerformed( ActionEvent ae )  {
			if ( ae.getSource() == jbtnOK )  {
				String Name = jtfName.getText();
				if ( Name.length() == 0 )  {
					JOptionPane.showMessageDialog(
						Namer.this,                 // for some reason, always <class name>.this
						"You didn't enter anything",
						"Possible Issue",
						JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(
						Namer.this,
						"Good Morning " + Name,
						"Salutations",
						JOptionPane.INFORMATION_MESSAGE);
				}
				jtfName.requestFocus();
			}
		}
	}
}
