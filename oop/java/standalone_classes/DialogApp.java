// LB 116  Book 2, Chapter2
import javax.swing.JOptionPane;

public class DialogApp  {

	public static void main(String[] args)  {
		String sInt;
		sInt = JOptionPane.showInputDialog("Enter an Integer:");
		int iResp = Integer.parseInt(sInt);
		System.out.println("You entered " + iResp + ".");
	}
}
