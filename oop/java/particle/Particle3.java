// TG 9
public class Particle3 {
  private double x;
  private double mass;

  public Particle3(double x) {
    this(x, 1.0);
  }
  public Particle3(double x, double mass) {
    this.x = x;
    this.mass = mass;
  }
  public double getX() {
    return x;
  }
  public void setX(double newX) {
    x = newX;
  }
  public double getWeight() {
    return 9.8 * mass;
  }
  public double distanceFromOrigin() {
    return Math.abs(x);
  }
}

