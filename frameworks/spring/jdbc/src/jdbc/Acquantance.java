package jdbc;

import java.util.*;

public class Acquantance  {

	private Integer id;

//	private Salutation salutation;

	private String fname;
	private String mi;
	private String lname;
	private String street;
	private String street2;
	private String city;
	private String state;
	private String zip;
	private String homePhone;
	private String dayPhone;
	private String cellPhone;
	private String email;
	private String spouse;
	private String comments;

	public Acquantance() {}

	public Acquantance(String fname, String mi, String lname, String street, String street2, String city, String state, String zip, String homePhone, String dayPhone, String cellPhone, String email, String spouse, String comments) {
		this.fname = fname;
		this.mi = mi;
		this.lname = lname;
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.homePhone = homePhone;
		this.dayPhone = dayPhone;
		this.cellPhone = cellPhone;
		this.email = email;
		this.spouse = spouse;
		this.comments = comments;
	}

	/*
	public Salutation getSalutation() { return this.salutation; }
	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}
	*/

	public String getFname() { return this.fname; }
	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMi() { return this.mi; }
	public void setMi(String mi) {
		this.mi = mi;
	}

	public String getLname() { return this.lname; }
	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getStreet() { return this.street; }
	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() { return this.street2; }
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() { return this.city; }
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() { return this.state; }
	public void setState(String state) {
		this.state = state;
	}

	public String getZip() { return this.zip; }
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getHomePhone() { return this.homePhone; }
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getDayPhone() { return this.dayPhone; }
	public void setDayPhone(String dayPhone) {
		this.dayPhone = dayPhone;
	}

	public String getCellPhone() { return this.cellPhone; }
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmail() { return this.email; }
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpouse() { return this.spouse; }
	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}

	public String getComments() { return this.comments; }
	public void setComments(String comments) {
		this.comments = comments;
	}

	public String toString()  {
		StringBuffer buffer = new StringBuffer();
		buffer.append(getFname()).append(" ").append(getMi()).append(" ").append(getLname());
		buffer.append(",").append(getStreet()).append(",").append(getStreet2()).append(", ").append(getCity()).append(",").append(getState());
		buffer.append(",").append(getZip()).append(",").append(getEmail());
		return buffer.toString();
	}
}
