// LB 315, book 3, chapter 6
import utilities.*;

public class OverrideMethod  {
	public static void main(String args[])  {
		PrtObj p = new PrtObj();
		Employee emp = new Employee("Andersen", "Derek");
		p.prtln( emp.toString() );
	}
}

class Employee  {
	private String lastName;
	private String firstName;

	public Employee( String lastName, String firstName )  {
		this.lastName = lastName;
		this.firstName = firstName;
	}

/* overriding the Object.toString method, inherited by all instantiated objects */
	public String toString()  {
		System.out.println("overriding Object.toString() method"); ////
		return "Employee: " + this.firstName + " " + this.lastName;
	}
}
