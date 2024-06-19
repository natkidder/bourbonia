/*-- Crume, p.74 */
package ch03;

public class User  {
	private String firstName;
	private String surname;
	private String loginName;
	private int age;

	public void setFirstName( String firstName )  {
		this.firstName = firstName;
	}
	public String getFirstName()  { return this.firstName; }

	public void setSurname( String surname )  {
		this.surname = surname;
	}
	public String getSurname() { return this.surname; }

	public void setLoginName( String loginName )  {
		this.loginName = loginName;
	}
	public String getLoginName() { return loginName; }

	public void setAge( int age )  {
		this.age = age;
	}
	public int getAge() { return age; }
}
