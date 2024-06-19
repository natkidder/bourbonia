//LB 554, book 6, chapter 2
import javax.swing.*;
import java.awt.event.*;

public class ClickMe3 extends JFrame    {
	public static void main(String[] args)   {
		new ClickMe3();
	}

	private JButton jbtnMain, jbtnExit;

	public ClickMe3()   {
		this.setSize(275, 100);
		this.setTitle("I'm Listening");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		ClickListener cl1 = new ClickListener();

		JPanel jpMain = new JPanel();

		addWindowListener( new WindowAdapter()   {
			public void windowClosing( WindowEvent we ) {
				jbtnExit.doClick();
			}
		} );

		jbtnMain = new JButton("Click Me!");
		jbtnMain.addActionListener(cl1);
		jpMain.add(jbtnMain);

		jbtnExit = new JButton("Exit");
		jbtnExit.addActionListener(cl1);
		jpMain.add(jbtnExit);

		this.add(jpMain);
		this.setVisible( true );
	}

	private class ClickListener implements ActionListener {
		private int intClickCnt = 0;

		public void actionPerformed( ActionEvent ae1 )   {
			if ( ae1.getSource() == jbtnMain )   {
				intClickCnt++;
				if (intClickCnt == 0)
					jbtnMain.setText("I've been clicked");
				else
					jbtnMain.setText("i've been clicked " + intClickCnt + " times");
			} else if ( ae1.getSource() == jbtnExit )   {
				if (intClickCnt > 0)
				    System.exit(0);
				else   {
				    JOptionPane.showMessageDialog(
						ClickMe3.this,
						"You must click the Click Me button at least once",
						"Don't exit so quickly",
						JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
