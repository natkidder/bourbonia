// LB 132  Book 2, Chapter 3
import java.util.Scanner;

public class CircleAreaApp  {

	static Scanner scIn = new Scanner(System.in);

	public static void main(String[] args)  {

		final double PI = 3.141592653;  // can also use Math.PI

		System.out.println("Velcome to the circle area calculator.");
		System.out.print("Enter the radius of your circle: ");
		double fRadius = scIn.nextDouble();
		double fArea = Math.PI * (fRadius * fRadius);
		System.out.println("The area of your circle is " + fArea);
	}
}
