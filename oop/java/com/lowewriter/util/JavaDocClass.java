// LB 355, book 3, chapter 8
package com.lowewriter.util;

/** Represents an employee
 * @author Doug Lowe
 * @author www.lowewriter.com
 * @version 1.5
 * @since 1.0
*/
public class JavaDocClass  {
	private String lastName;
	private String firstName;
	private Double salary;

/** Represents the employee's address
*/
	public Address address;

/** Creates an employee with the specified name
 * @param lastName The employee's last name
 * @param firstName The employee's first name
*/
	public JavaDocClass( String lastName, String firstName )   {
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = new Address();
	}

/** Gets the employee's last name
 * @return A string representing the employee's last name
*/
	public String getLastName()  {
		return this.lastName;
	}

/** Sets the employee's last name
 * @param lastName A string containing the employee's last name
 * @return no return value
*/
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

/** Gets the employee's first name
 * @return A string representing the employee's first name
*/
	public String getFirstName()   {
		return this.firstName;
	}

/** Sets the employee's first name
 * @param firstName A string containing the employee's first name
 * @return no return value
*/
	public void setFirstName( String firstName )   {
		this.firstName = firstName;
	}

/** Gets the employee's salary
 * @return A Double representing the employee's salary
*/
	public Double getSalary()  {
		return this.salary;
	}

/** Sets the employee's salary
 * @param salary A double containing the employee's salary
 * @return no return value
*/
	public void setSalary( Double salary )  {
		this.salary = salary;
	}
}

class Address implements Cloneable   {
	private String street;
	private String city;
	private String state;
	private String zip;

/** Constructs blank address
 * @param No parameters
 * @return No return value
*/
	public Address()  {
		this.street = "";
		this.city = "";
		this.state = "";
		this.zip = "";
	}

/** Constructs filled address
 * @param street the street addess (eg. 4935 Melinda Ct.)
 * @param city the city (eg. Aspen Hill)
 * @param state the state (eg. Maryland)
 * @param zip the zip code (eg. 20853)
 * @return no return value
*/
	public Address( String street, String city, String state, String zip )  {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
}
