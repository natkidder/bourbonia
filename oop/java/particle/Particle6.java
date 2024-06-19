import java.awt.*;
public class Particle6 {
	private double x, y, vx, vy, ax, ay;
	private double mass = 1.0;
	private boolean firststep = true;

	public Particle6(double x, double y, double vx, double vy)  {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}

	public double getMass()  {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getX()  {
		return x;
	}

	public double getY()  {
		return y;
	}

	public double getVx()  {
		return vx;
	}

	public double getVy()  {
		return vy;
	}

	public double getAx()  {
		return ax;
	}

	public double getAy()  {
		return ay;
	}

	public void setX(double x)  {
		this.x = x;
	}

	public void setY(double y)  {
		this.y = y;
	}

	public void setVx(double vx)  {
		this.vx = vx;
	}

	public void setVy(double vy)  {
		this.vy = vy;
	}

    public void step(double dt, Force f)  {
		if (firststep)  {
			ax = f.getfx(x, y, vx, vy, this) / mass;  // acceleration at beginning of interval
			ay = f.getfy(x, y, vx, vy, this) / mass;
			firststep = false;
		}
		// Euler-Richardson algorithm
		double vxm = vx + 0.5 * ax * dt;  // velocity at middle of interval
		double vym = vy + 0.5 * ay * dt;
		double xm = x + 0.5 * vx * dt;    // position at middle of interval
		double ym = y + 0.5 * vy * dt;
        double axm = f.getfx(xm, ym, vxm, vym, this) / mass;
        double aym = f.getfy(xm, ym, vxm, vym, this) / mass;
        vx += axm * dt;
        vy += aym * dt;
        x += vxm * dt;
        y += vym * dt;
        ax = f.getfx(x, y, vx, vy, this) / mass;
        ay = f.getfy(x, y, vx, vy, this) / mass;
	}
}
