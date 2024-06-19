// TG 18
public class Point
{
	// define instance data
	public double x, y;   //instance variables

	// define constructors

	public Point()
	{
		x = 1;   // same variables as instance variables
		y = 1;
	}

	public Point (double x, double y)
	{
		this.x = x;   // this.x refers to an instance variable
		this.y = y;
		this.x++;
		System.out.println("Point 2 args: this.x = " + this.x);
		System.out.println("x = " + x);   // parameter value
	}

	public Point (double x, double y, boolean dummy)
	{
		x++;
		System.out.println("Point 3 args: x = " + x);
	}
}
