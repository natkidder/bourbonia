// TG 11
public class Particle4 {
  double x, y, mass;

  public Particle4(double x, double y)
  {
    this(x, y, 10);
  }

  public Particle4(double x, double y, double mass)
  {
	  this.x = x;
	  this.y = y;
	  this.mass = mass;
  }

  public double distanceFrom(Particle4 a)
  {
	  double r2 = Math.pow(this.x - a.x, 2) + Math.pow(this.y - a.y,2);
	  return Math.sqrt(r2);
  }

  public double distanceFromOrigin()
  {
	  return Math.sqrt(x*x + y*y);
  }
}
