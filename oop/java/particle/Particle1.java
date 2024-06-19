// TG 5
public class Particle1 {
  double x, y, vx, vy, mass;

  // examples of multiple constructors

  public Particle1 () {
    this(0.0,0.0);
  }
  public Particle1(double x, double y) {
    this(x,y,1.0);
  }
  public Particle1(double x, double y, double m) {
    this(x,y,0.0,0.0,m);
  }
  public Particle1(double x, double y, double vx, double vy) {
    this(x,y,vx,vy,1.0);
  }
  public Particle1(double x, double y, double vx, double vy, double mass) {
    this.x = x;
    this.y = y;
    this.vx = vx;
    this.vy = vy;
    this.mass = mass;
  }
}


