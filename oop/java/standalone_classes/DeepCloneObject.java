// LB 330, book 3, chapter 6
import utilities.*;

public class DeepCloneObject  {

	public static void main(String args[])  {

		PrtObj p = new PrtObj();

		Employee empObj1 = new Employee("Anniston", "Jennifer");
// need only a dot after the integer value to make it a double
		empObj1.setSalary(1500.);
		empObj1.address = new Address("14 Rodeo Drive", "Beverly Hills", "CA", "90210");

		Employee empObj2 = (Employee)empObj1.clone();

		p.prtln("===== after cloning =====");
		printEmployee( empObj1 );
		printEmployee( empObj2 );

		empObj2.setLastName("Pitt");
		empObj2.address = new Address("57 Melbourne Road", "Hollywood", "FL", "33495");

		p.prtln("===== after changing empObj2 =====");
		printEmployee( empObj1 );
		printEmployee( empObj2 );

	}

	private static void printEmployee( Employee e )  {
		PrtObj p = new PrtObj();
		p.prtln( e.getFirstName() + " " + e.getLastName() );
		p.prtln( e.address.getAddress() );
		p.prtln( "Salary: " + e.getSalary() + "\n" );
	}
}

// NOTE the implements Cloneable
class Employee implements Cloneable  {
	private String lastName;
	private String firstName;
	private Double salary;

	public Address address;

	public Employee( String lastName, String firstName )  {
		this.lastName = lastName;
		this.firstName = firstName;
// declaring the Address variable inside the constructor
		this.address = new Address();
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

	public Employee clone()  {

		Employee empObj;

		try   {
// shallow copy
			empObj = (Employee)super.clone();
// deep copy
			empObj.address = (Address)address.clone();
		}
		catch (CloneNotSupportedException ex)  {
			return null; //will never happen
		}
		return empObj;
	}

	public String toString()   {
		return this.getClass().getName() + "[" + this.firstName + " " + this.lastName + ", " + this.salary + "]";
	}
}

// NOTE this implements Cloneable
class Address implements Cloneable   {
	private String street;
	private String city;
	private String state;
	private String zip;

	public Address()  {
		this.street = "";
		this.city = "";
		this.state = "";
		this.zip = "";
	}

	public Address( String street, String city, String state, String zip )  {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Object clone()  {

		try  {
			return super.clone();
		}
		catch (CloneNotSupportedException ex)  {
			return null;  //will never happen
		}
	}

	public String getAddress()  {
		return this.street + "\n" + this.city + ", " + this.state + " " + this.zip;
	}
}
