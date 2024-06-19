//LB 547, book 6, chapter 2
import javax.swing.*;  // javax because java.swing was already taken
import java.awt.event.*;

public class ClickEvent extends JFrame implements ActionListener  {

	public static void main(String args[])  {
		new ClickEvent();
	}

	private JButton jbMain;

// JFrame class constructor
	public ClickEvent()  {
		this.setSize( 200 , 100 );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setTitle("I'm Listening");

		JPanel jpMain = new JPanel();
		jbMain = new JButton("Click Me");
		jbMain.addActionListener(this);
		jpMain.add(jbMain);
		this.add(jpMain);

		this.setVisible( true );

	}

	private int iClickCnt = 0;

// generic action event
	public void actionPerformed( ActionEvent aevnt )   {
// if event source is a certain control
		if ( aevnt.getSource() == jbMain )   {
			iClickCnt++ ;
			if ( iClickCnt == 1 )  {
				jbMain.setText("I've been clicked");
			} else   {
				jbMain.setText("I've been clicked " + iClickCnt + " times");
			}
		}
	}
}
