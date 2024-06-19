import java.awt.*;
public class Simulation extends Frame
{
	public static void main(String[] args)   {
		Simulation sim = new Simulation();  // set up window for application
	}

	public Simulation()  {
		setSize(513, 342);
		setVisible(true);
	}

	public void paint(Graphics g)  {
		setBackground(Color.white);
		calculateTrajectory(g);
	}

	private void calculateTrajectory(Graphics g)  {
		final double tmax = 10.0;
		final double dt = 0.5;
		Particle6 p = new Particle6(0.0, 200.0, 40.0, 25.0);
		Force f = new Force();
		g.setColor(Color.blue);
		double time = 0.0;
		while (time < tmax)  {
			//draw circle of 10 pixels. NOTE use of casting.
			g.drawOval((int)p.getX(), getSize().height - (int)p.getY(), 10, 10);
			p.step(dt, f);
			time += dt;
		}
	}
}
