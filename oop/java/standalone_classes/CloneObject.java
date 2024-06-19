// LB 324, book 3, chapter 6
import utilities.*;

public class CloneObject  {
	public static void main(String args[])  {
		PrtObj p = new PrtObj();

		Employee empObj1 = new Employee("Anniston", "Jennifer");
		empObj1.setSalary(1200.0);

/* simply assigning empObj1 to empObj2 would mean both objects have Jennifer Brosnan */
		Employee empObj2 = empObj1.clone();
		empObj1.setLastName("Pitt");

		p.prtln(empObj1.toString());
		p.prtln(empObj2.toString());
	}
}

class Employee  {
	private String lastName;
	private String firstName;
	private Double salary;

	public Employee( String lastName, String firstName )  {
		this.lastName = lastName;
		this.firstName = firstName;
	}
	public String getLastName()   {
		return this.lastName;
	}
	public void setLastName( String lastName )  {
		this.lastName = lastName;
	}
	public String getFirstName()   {
		return this.firstName;
	}
	public void setFirstName( String firstName )  {
		this.firstName = firstName;
	}
	public Double getSalary()   {
		return this.salary;
	}
	public void setSalary( Double salary )  {
		this.salary = salary;
	}

/* in the book, it returns a type Object, rather than a type Employee */
	public Employee clone()  {
		Employee empObj;
		empObj = new Employee( this.getLastName(), this.getFirstName()  );
		empObj.setSalary( this.getSalary() );
		return empObj;
	}

	public String toString()  {
		return this.getClass().getName() + "[" + this.firstName + " " + this.lastName + " " + this.salary + "]";
	}
}
