public class Force  {
	private final static double G = 9.8;
	double b = 0;   //used in drag force

	public void setb(double b)  {
		this.b = b;
	}

	public double getfx(double x, double y, double vx, double vy, Particle6 p) {
		return -b * vx;
	}

	public double getfy(double x, double y, double vx, double vy, Particle6 p) {
		return -b * vx - G * p.getMass();
	}
}
