//LB 532, book 6, chapter 1
import javax.swing.*;  // javax because java.swing was already taken

public class HelloFrame extends JFrame   {
	public static void main(String[] args)   {
		new HelloFrame();
	}

	public HelloFrame()  {
		this.setSize( 400 , 400 );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setTitle( "Hello World" );
		JPanel jp = new JPanel();
		jp.setLocation( 0 , 0 );
		jp.setSize( 100 , 50 );
		JLabel jl = new JLabel("Hello World");
		jp.add(jl);
		this.add(jp);
		JPanel jp2 = new JPanel();
		jp2.setLocation( 200 , 300);
		jp2.setSize( 70 , 70 );
		JButton jbClick = new JButton();
		jbClick.setText("Click Me");
		jbClick.setContentAreaFilled(false);
		jbClick.setToolTipText("Click to activate");
		jp2.add(jbClick);
		this.add(jp2);
		this.setVisible( true );
	}
}
