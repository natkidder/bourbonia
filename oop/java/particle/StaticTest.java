// TG 14

public class StaticTest
{
	public static int x = 0;
	public int y = 0;

	public String getCoordinates()
	{
		return "x = " + x + ", y = " + y;
	}

	public static void main(String[] args)
	{
		StaticTest a = new StaticTest();
		StaticTest b = new StaticTest();
		a.x = 5;    // static variable
		a.y = 12;   // instance variable
		System.out.println(a.getCoordinates());   // outputs 5, 12
		b.x = 7;
		b.y = 13;
		System.out.println(a.getCoordinates());  // outputs 7, 12
		System.out.println(b.getCoordinates());  // outputs 7, 13
		StaticTest.x = 2;
		System.out.println(a.getCoordinates());  // outputs 2, 12
		System.out.println(b.getCoordinates());  // outputs 2, 13
	}
}
