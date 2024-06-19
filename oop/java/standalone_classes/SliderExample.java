// LB 583, Book 6, Chapter 3
/* illustrates slider*/

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class SliderExample extends JFrame  {

	JButton btnOK;
	JSlider sliderMain;
	JLabel lblResult;

	public static void main( String[] args )  {
		new SliderExample();
	}

	public SliderExample()  {
		this.setSize( 500, 200 );
		this.setTitle("Rate Obama");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		ButtonListener bl = new ButtonListener();
		SliderListener sl = new SliderListener();

		JPanel jpMain = new JPanel();
		JPanel jpSlider = new JPanel();
		JPanel jpBtn = new JPanel();
		JPanel jpLbl = new JPanel();

		sliderMain = new JSlider( 0, 100 );
		sliderMain.setMajorTickSpacing(10);
		sliderMain.setMinorTickSpacing(5);
		sliderMain.setPaintTicks( true );
		sliderMain.setPaintLabels( true );
		sliderMain.addChangeListener(sl);
		jpSlider.add( sliderMain );
		jpMain.add( jpSlider);

		btnOK = new JButton("OK");
		btnOK.addActionListener(bl);
		jpBtn.add(btnOK);
		jpMain.add( jpBtn );

		lblResult = new JLabel("");
		jpLbl.add(lblResult);
		jpMain.add( jpLbl );

		this.add( jpMain );
		this.setVisible( true );
	}

	private class ButtonListener implements ActionListener  {
		public void actionPerformed( ActionEvent ae )  {
			if ( ae.getSource() == btnOK )  {
				Integer iVal = sliderMain.getValue();
				lblResult.setText( "You rate Obama " + iVal.toString() + " out of 100" );
			}
		}
	}

	private class SliderListener implements ChangeListener  {
		public void stateChanged( ChangeEvent ce )  {
			if ( sliderMain.getValue() < 20 )  {
				lblResult.setText("Better hire a new political consultant");
			} else {
				lblResult.setText("");
			}
		}
	}

}
