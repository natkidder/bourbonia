import java.awt.*;
public class ParticleDrawer extends Frame  {

	public static void main(String[] args)  {
		// Create new frame
		ParticleDrawer frame = new ParticleDrawer();
	}

	// Construct ParticleDrawer frame
	public ParticleDrawer()  {
		// predefined methods
		setSize(512, 342);  // units of coordinate system in pixels
		setVisible(true);
	}

	// Paint particles
	public void paint (Graphics g)  {
		Particle5 p = new Particle5(3.1, 4.1);
		p.draw(g);
		p.move(26.5, 35.8);
		p.setColor(Color.red);
		p.draw(g);
	}
}
