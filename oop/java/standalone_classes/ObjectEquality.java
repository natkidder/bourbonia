// LB 317, book 3, chapter 6
import utilities.*;

public class ObjectEquality  {
	public static void main(String args[])  {
		PrtObj p = new PrtObj();
		Employee empObj1 = new Employee("Edwards", "Braylon");
		Employee empObj2 = new Employee("Edwards", "Braylon");

		if ( empObj1 == empObj2 )
			p.prtln("These employees, having the same property values, are the same using the == operator.");
		else
			p.prtln("These are different employees, despite having the same property values using the == operator.");

/* the equals method is inherited from the Object class */
		if ( empObj1.equals(empObj2) )
			p.prtln("These employees, having the same property values, are the same using the 'equals' method.");
		else
			p.prtln("These are different employees, despite having the same property values using the 'equals' method.");
	}
}

class Employee  {
	private String lastName;
	private String firstName;

	public Employee( String lastName, String firstName )  {
		this.lastName = lastName;
		this.firstName = firstName;
	}
}
