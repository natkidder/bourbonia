import java.awt.*;
public class Particle5 {
	double x, y;
	Color color;

	public Particle5(double x, double y)  {
		//constructor with color variable
		this.x = x;
		this.y = y;
		color = Color.blue;    // define default color
	}

    //Draw representation of particle in given graphics context
    public void draw(Graphics g)  {
		Color oldColor = g.getColor();
		g.setColor(color);
		g.fillOval((int)x, (int)y, 12, 12);
		g.setColor(oldColor);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color newColor) {
		color = newColor;
	}

	public void move(double dx, double dy)  {
		x += dx;
		y += dy;
	}
}
