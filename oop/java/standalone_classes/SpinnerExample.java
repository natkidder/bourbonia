// LB 596, Book 6, Chapter 4
/* example of 2 different kinds of spinners */

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import utilities.*;

public class SpinnerExample extends JFrame  {

	JButton jbtnMain;
	JSpinner spinnerMonths;
	JSpinner spinnerWeekdays;
	JLabel jlResult;
	String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
					   "October", "November", "December"};
	String[] weekdays = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	PrtObj p = new PrtObj();

	public static void main(String args[])   {
		new SpinnerExample();
	}

	public SpinnerExample()  {
		this.setSize( 500, 400);
		this.setTitle("Select the 1st Weekday of a Given Month");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		JPanel jpMain = new JPanel();

		ButtonListener bl = new ButtonListener();

//		JLabel jlMain = new JLabel("");
//		(jlMain);

		spinnerMonths = new JSpinner( new SpinnerNumberModel( 1, 1, 12, 1 ) );
		jpMain.add(spinnerMonths);

		spinnerWeekdays = new JSpinner( new SpinnerListModel( weekdays ) );
		jpMain.add( spinnerWeekdays );

		jbtnMain = new JButton("OK");
		jbtnMain.addActionListener(bl);
		jpMain.add(jbtnMain);

		jlResult = new JLabel("");
		jpMain.add(jlResult);

		this.add(jpMain);
		this.setVisible(true);
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed( ActionEvent e )  {
			if ( e.getSource() == jbtnMain )  {
				String sMonth;
				sMonth = spinnerMonths.getValue().toString();
				int iMonth = Integer.parseInt(sMonth);
				iMonth--;
				String month = months[iMonth];
				String weekday = spinnerWeekdays.getValue().toString();
				jlResult.setText("You chose the first " + weekday + " of " + month);
			}
		}
	}
}
