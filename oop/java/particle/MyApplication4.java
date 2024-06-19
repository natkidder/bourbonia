// TG 12
public class MyApplication4
{
  public static void main(String[] args)
  {
	  Particle4 a = new Particle4(5.0, 7.0);
	  Particle4 b = new Particle4(1.0, 2.0);
	  System.out.println("Distance of a from b = " + a.distanceFrom(b));
	  System.out.println("Distance of b from a = " + b.distanceFrom(a));
  }
}
