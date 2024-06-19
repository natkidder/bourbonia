// LB 84 & 85, part 2, chapter 1
/* a simple greeter class that displays a message on the console */

/*
public class Greeter  {
	public void sayHello(String strMsg)   {
		System.out.println(strMsg);
	}
}
*/

import javax.swing.JOptionPane;

public class Greeter   {
	public void sayHello(String strMsg)  {
		JOptionPane.showMessageDialog(null, strMsg, "Greeter", JOptionPane.INFORMATION_MESSAGE);
	}
}
