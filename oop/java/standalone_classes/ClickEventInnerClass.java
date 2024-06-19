//LB 547, book 6, chapter 2
import javax.swing.*;  // javax because java.swing was already taken
import java.awt.event.*;

public class ClickEventInnerClass extends JFrame implements ActionListener  {
	public static void main(String[] args)  {
		new ClickEventInnerClass();
	}

	private JButton jbtnMain;

	public ClickEventInnerClass()  {
		this.setSize(200, 100);
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setTitle("I'm Listening!");

		JPanel jpMain = new JPanel();
		jbtnMain = new JButton("Click Me");
		jbtnMain.addActionListener(this);
		jpMain.add(jbtnMain);
		this.add(jpMain);
		this.pack();

		this.setVisible(true);
	}

	private int ClickCnt = 0;

	public void actionPerformed( ActionEvent aEvent )  {
		if ( aEvent.getSource() == jbtnMain )   {
			ClickCnt++;
			if (ClickCnt == 1)   {
				jbtnMain.setText("I've been clicked");
			} else {
				jbtnMain.setText("I've been clicked " + ClickCnt + " times");
			}
			this.pack();
		}
	}
}

