// derived from Crume, p. 108
package rnk;

public class ContactInfo  {
	private String street;
	private String city;
	private String state;
	private String zip;
	private String homePhone;
	private String cellPhone;
	private String textPhone;
	private String email;

	public void setStreet( String street ) { this.street = street; }
	public String getStreet() { return this.street; }

	public void setCity( String city ) { this.city = city; }
	public String getCity() { return this.city; }

	public void setState( String state ) { this.state = state; }
	public String getState() { return this.state; }

	public void setZip( String zip ) { this.zip = zip; }
	public String getZip() { return this.zip; }

	public void setHomePhone( String homePhone ) { this.homePhone = homePhone; }
	public String getHomePhone() { return this.homePhone; }

	public void setCellPhone( String cellPhone ) { this.cellPhone = cellPhone; }
	public String getCellPhone() { return this.cellPhone; }

	public void setTextPhone( String textPhone ) { this.textPhone = textPhone; }
	public String getTextPhone() { return this.textPhone; }

	public void setEmail( String email ) { this.email = email; }
	public String getEmail() { return this.email; }
}
