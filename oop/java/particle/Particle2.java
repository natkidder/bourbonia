// TG 6
public class Particle2 {
  double x, y, mass;
  public Particle2() {
  }
  public Particle2(double x, double y) {
    this(x,y,1);
  }
  public Particle2(double x, double y, double mass) {
    this.x = x; this.y = y; this.mass = mass;
  }
  public double getWeight() {
    return 9.8*mass;
  }
  public double distanceFromOrigin() {
    return Math.sqrt(x*x + y*y);
  }
}

