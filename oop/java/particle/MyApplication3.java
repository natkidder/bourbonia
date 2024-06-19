// TG 10
public class MyApplication3
{
  public static void main(String[] args)
  {
    Particle3 p = new Particle3(10.0, 2.0);
    System.out.println("Distance of particle form origin = " + p.distanceFromOrigin());
    System.out.println("x-coordinate = " + p.getX()); // try it with just p.x
//    System.out.println("x-coordinate = " + p.x); // remember, x is private
    System.out.println("weight = " + p.getWeight());
    p.setX(3.0); // try also p.x = 3.0
//    p.x = 3.0;   // remember, x is private
    System.out.println("new x-coordinate = " + p.getX());
    System.out.println("nex distance from origin = " + p.distanceFromOrigin());
  }
}
