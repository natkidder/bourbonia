package app;
// Generated Mar 16, 2010 9:54:57 AM by Hibernate Tools 3.2.0.b9


import java.math.BigDecimal;
import java.util.Date;
import org.apache.struts.action.ActionForm;

/**
 * Holds a single resume, including the document image
 */
public class Resume extends ActionForm implements java.io.Serializable {

     protected int id;
     protected String firstName;
     protected String mi;
     protected String lastName;
     protected String currEmployed;
     protected String street;
     protected String apt;
     protected String city;
     protected String state;
     protected String zip;
     protected String hphone;
     protected String ophone;
     protected String cphone;
     protected String workCity;
     protected String workState;
     protected String email;
     protected String birthMth;
     protected String birthDay;
     protected String birthYr;
     protected Date birthDt;
     protected String gender;
     protected BigDecimal lowSalary;
     protected BigDecimal highSalary;
     protected String relocation;
     protected String comments;
     protected String skill;
     protected Integer yearsExp;

    public Resume() {
    }

    public Resume(String firstName, String mi, String lastName, String currEmployed, String street, String apt, String city, String state, String zip, String hphone, String ophone, String cphone, String workCity, String workState, String email, String birthMth, String birthDay, String birthYr, Date birthDt, String gender, BigDecimal lowSalary, BigDecimal highSalary, String relocation, String comments, String skill, Integer yearsExp) {
       this.firstName = firstName;
       this.mi = mi;
       this.lastName = lastName;
       this.currEmployed = currEmployed;
       this.street = street;
       this.apt = apt;
       this.city = city;
       this.state = state;
       this.zip = zip;
       this.hphone = hphone;
       this.ophone = ophone;
       this.cphone = cphone;
       this.workCity = workCity;
       this.workState = workState;
       this.email = email;
       this.birthMth = birthMth;
       this.birthDay = birthDay;
       this.birthYr = birthYr;
       this.birthDt = birthDt;
       this.gender = gender;
       this.lowSalary = lowSalary;
       this.highSalary = highSalary;
       this.relocation = relocation;
       this.comments = comments;
       this.skill = skill;
       this.yearsExp = yearsExp;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMi() {
        return this.mi;
    }
    
    public void setMi(String mi) {
        this.mi = mi;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCurrEmployed() {
        return this.currEmployed;
    }
    
    public void setCurrEmployed(String currEmployed) {
        this.currEmployed = currEmployed;
    }
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    public String getApt() {
        return this.apt;
    }
    
    public void setApt(String apt) {
        this.apt = apt;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return this.zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getHphone() {
        return this.hphone;
    }
    
    public void setHphone(String hphone) {
        this.hphone = hphone;
    }
    public String getOphone() {
        return this.ophone;
    }
    
    public void setOphone(String ophone) {
        this.ophone = ophone;
    }
    public String getCphone() {
        return this.cphone;
    }
    
    public void setCphone(String cphone) {
        this.cphone = cphone;
    }
    public String getWorkCity() {
        return this.workCity;
    }
    
    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }
    public String getWorkState() {
        return this.workState;
    }
    
    public void setWorkState(String workState) {
        this.workState = workState;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBirthMth() {
        return this.birthMth;
    }
    
    public void setBirthMth(String birthMth) {
        this.birthMth = birthMth;
    }
    public String getBirthDay() {
        return this.birthDay;
    }
    
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    public String getBirthYr() {
        return this.birthYr;
    }
    
    public void setBirthYr(String birthYr) {
        this.birthYr = birthYr;
    }
    public Date getBirthDt() {
        return this.birthDt;
    }
    
    public void setBirthDt(Date birthDt) {
        this.birthDt = birthDt;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public BigDecimal getLowSalary() {
        return this.lowSalary;
    }
    
    public void setLowSalary(BigDecimal lowSalary) {
        this.lowSalary = lowSalary;
    }
    public BigDecimal getHighSalary() {
        return this.highSalary;
    }
    
    public void setHighSalary(BigDecimal highSalary) {
        this.highSalary = highSalary;
    }
    public String getRelocation() {
        return this.relocation;
    }
    
    public void setRelocation(String relocation) {
        this.relocation = relocation;
    }
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getSkill() {
        return this.skill;
    }
    
    public void setSkill(String skill) {
        this.skill = skill;
    }
    public Integer getYearsExp() {
        return this.yearsExp;
    }
    
    public void setYearsExp(Integer yearsExp) {
        this.yearsExp = yearsExp;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("firstName").append("='").append(getFirstName()).append("' ");			
      buffer.append("mi").append("='").append(getMi()).append("' ");			
      buffer.append("lastName").append("='").append(getLastName()).append("' ");			
      buffer.append("email").append("='").append(getEmail()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


