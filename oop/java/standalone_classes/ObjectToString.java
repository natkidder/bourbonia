// LB 315, book 3, chapter 6
import utilities.*;

public class ObjectToString  {
	public static void main(String[] args)   {
		PrtObj p = new PrtObj();
		Employee empObj = new Employee("Keeney", "Karen");
		p.prtln( "empObj.toString(): " + empObj.toString() );
		Prt.prtln( "empObj           : " + empObj );
	}
}

class Employee   {
	private String lastName;
	private String firstName;

	public Employee(String lastName, String firstName)  {
		this.lastName = lastName;
		this.firstName = firstName;
	}
}
