import javax.swing.*;
public class ComboExample extends JFrame  {
	JButton btnOK;
	public static void main( String[] args )  {
	public ComboExample()  {
		ButtonListener bl = new ButtonListener();
		JPanel jpMain = new JPanel();
		cboMain = new JComboBox(AL);
		btnOK = new JButton("OK");
		lblResult = new JLabel("");
		this.add( jpMain );
	private class ButtonListener implements ActionListener  {
}
