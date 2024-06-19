// TG 31
import java.awt.*;
import java.awt.event.*;

class ParameterIntput extends Frame  {
	TextField tf;
	Label lb;
	Simulation2 sim;

	public void FrictionInput(Simulation2 sim)  {  // pass address of object
		this.sim = sim;
		setUpFrame();
  	}

  	public void setUpFrame()  {
		setTitle("Friction Input");
		setSize(200, 100);
		setLocation(400, 50);  // location for frame
		setLayout(null);  // not using any layout manager
		lb = new Label("Friction Coefficient");  // new label for text field
		lb.setSize(150, 20);
		lb.setLocation(30, 70);
		add(lb);
		tf = new TextField();
		tf.addActionListener(new actionTF());  // actionTF is instantiated here
		tf.setSize(50, 20);
		tf.setLocation(30, 40);
		add(tf);
		setVisible(true);
	}

	class actionTF implements ActionListener  { // example of internal class

		public void actionPerformed(ActionEvent e)  {
			Double R = new Double(tf.getText().trim());  // convert text to number
			// 'trim' gets rid of extra zeroes
			sim.calculateTrajectory(R.doubleValue());
		}
	}
}

