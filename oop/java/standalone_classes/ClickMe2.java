//LB 549, book 6, chapter 2
import javax.swing.*;
import java.awt.event.*;

public class ClickMe2 extends JFrame   {
	public static void main(String Args[])    {
		new ClickMe2();
	}

	private JButton jbtnMain;

	public ClickMe2()    {
		this.setSize(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("I'm Listening");

		ClickListener clClicked = new ClickListener();

		JPanel jpMain = new JPanel();
		jbtnMain = new JButton("Click Me");
		jbtnMain.addActionListener(clClicked);
		jpMain.add(jbtnMain);
		this.add(jpMain);


		this.setVisible(true);
	}

	private class ClickListener implements ActionListener   {
		private int intClickCount = 0;

		public void actionPerformed( ActionEvent aeMain )  {
			if (aeMain.getSource() == jbtnMain)   {
				intClickCount++;
				if (intClickCount == 1)
				    jbtnMain.setText("I've been Clicked!");
				else
				    jbtnMain.setText("I've been Clicked " + intClickCount + " times!");
			}
		}
	}
}
