package web;

public class Acquantance implements java.io.Serializable {
	public Acquantance() {}

	private String fname;   
	private String lname;   
	private String mi;       
	private String street;   
	private String street2;  
	private String city;     
	private String state;    
	private String zip;      
	private String hphone;  
	private String dphone;  
	private String email;    
	private String spouse;   
	private String comments; 

	public void setFname(String fname)  {
		this.fname = fname;   
	}
	public String getFname() {   
		return this.fname;
	}

	public void setLname(String lname)  {
		this.lname = lname;   
	}
	public String getLname() {   
		return this.lname;
	}

	public void setMi(String mi)  {
		this.mi = mi;       
	}
	public String getMi() {       
		return this.mi;
	}

	public void setStreet(String street)  {
		this.street = street;   
	}
	public String getStreet() {   
		return this.street;   
	}

	public void setStreet2(String street2)  {
		this.street2 = street2;  
	}
	public String getStreet2() {  
		return this.street2;  
	}

	public void setCity(String city)  {
		this.city = city;     
	}
	public String getCity() {     
		return this.city;     
	}

	public void setState(String state)  {
		this.state = state;    
	}
	public String getState() {    
		return this.state;    
	}

	public void setZip(String zip)  {
		this.zip = zip;      
	}
	public String getZip() {      
		return this.zip;      
	}

	public void setHphone(String hphone)  {
		this.hphone = hphone;  
	}
	public String getHphone() {  
		return this.hphone;  
	}

	public void setDphone(String dphone)  {
		this.dphone = dphone;  
	}
	public String getDphone() {  
		return this.dphone;  
	}

	public void setEmail(String email)  {
		this.email = email;    
	}
	public String getEmail() {    
		return this.email;    
	}

	public void setSpouse(String spouse)  {
		this.spouse = spouse;   
	}
	public String getSpouse() {   
		return this.spouse;   
	}

	public void setComments(String comments)  {
		this.comments = comments; 
	}
	public String getComments() { 
		return this.comments; 
	}

}
