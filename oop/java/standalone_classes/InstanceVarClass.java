// LB 273, book 3, chapter 3
// illustrates use of instance, as opposed to class, variables

public class InstanceVarClass   {

	public int iX = 5;   // no 'static', so an instance field

	public static void main(String[] args)   {

// will not compile as main cannot see iX.  iX is an instance variable and main is a static method

		int iY = iX;

	}
}
