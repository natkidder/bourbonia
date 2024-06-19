// LB 321, book 3, chapter 6
import utilities.*;

public class ObjectEqualityOverride  {
	public static void main(String args[])  {
		PrtObj p = new PrtObj();
		Employee empObj1 = new Employee("Winslow", "Kellen");
		Employee empObj2 = new Employee("Winslow", "Kellen");

		if ( empObj1.equals(empObj2) )
			p.prtln("The two employees, with identical property values, are the same, using the overriding equals method.");
		else
			p.prtln("The two employees, despite identical property values, are different, using the overriding equals method.");

	}
}

class Employee  {
	private String lastName;
	private String firstName;

	public Employee( String lastName, String firstName )  {
		this.lastName = lastName;
		this.firstName = firstName;
	}
	public String getLastName()  {
		return this.lastName;
	}
	public String getFirstName()  {
		return this.firstName;
	}
/* method that overrides Object.equals */
	public boolean equals(Object obj)  {

// testing reflexivity
		if ( this == obj )
			return true;

// no object equals null
		if ( this == null )
			return false;

// objects of different types are never equal
		if ( this.getClass() != obj.getClass() )
			return false;

// cast to an Employee, then compare the fields
		Employee empObj = (Employee)obj;
		return this.lastName.equals(empObj.lastName) && this.firstName.equals(empObj.firstName);
	}
}
