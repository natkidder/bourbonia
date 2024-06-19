//TG 29
import java.awt.*;
public class Simulation2 extends Frame {
	Image offscreen;  // make image class variable availabel to all methods

	public static void main(String[] args)  {
		Simulation2 sim = new Simulation2();   // set up window for application
	}

	public Simulation2()  {
		setSize(512, 342);
		setVisible(true);
		offscreen = createImage(getSize().width, getSize().height);
		calculateTrajectory();
	}

	public void paint(Graphics g)  {
		setBackground(Color.green);
		g.drawImage(offscreen, 0, 0, this);  // draw image onto screen
	}

	public void calculateTrajectory()  {
		final double tmax = 10.0;
		final double dt = 0.5;
		Graphics g = offscreen.getGraphics();
		g.setColor(Color.blue);
		Particle6 p = new Particle6(0.0, 200.0, 40.0, 25.0);
		Force f = new Force();
		double time = 0.0;
		while (time < tmax)  {
			System.out.println(time + ", " + tmax); ////
			g.drawOval((int)p.getX(), getSize().height - (int)p.getY(), 10, 10);
			p.step(dt, f);
			time += dt;
		}
	}
}
