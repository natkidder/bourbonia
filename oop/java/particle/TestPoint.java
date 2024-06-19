// TG 19
public class TestPoint
{
	public static void main(String[] args)
	{
		/* Need an instance of class Particle - a particle object.
		assign it to the variable that is of type Particle */
		Point a = new Point(2.0, 1.0);
		System.out.println("TestPoint: xa = " + a.x);
		Point b = new Point();
		b.x = 3.0;
		System.out.println("TestPoint: xb = " + b.x);
	}
}
