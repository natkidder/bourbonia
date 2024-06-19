// derived from Crume, p. 108
package rnk;

public class Reference  {
	private String name;
	private String company;
	private String title;
	private String phoneType;
	private String phoneNbr;
	private String email;
	private String relationship;

	public void setName( String name ) { this.name = name; }
	public String getName() { return this.name; }

	public void setCompany( String company ) { this.company = company; }
	public String getCompany() { return this.company; }

	public void setTitle( String title ) { this.title = title; }
	public String getTitle() { return this.title; }

	public void setPhoneType( String phoneType ) { this.phoneType = phoneType; }
	public String getPhoneType() { return this.phoneType; }

	public void setPhoneNbr( String phoneNbr ) { this.phoneNbr = phoneNbr; }
	public String getPhoneNbr() { return this.phoneNbr; }

	public void setEmail( String email ) { this.email = email; }
	public String getEmail() { return this.email; }

	public void setRelationship( String relationship ) { this.relationship = relationship; }
	public String getRelationship() { return this.relationship; }
}
