package app;
// Generated Mar 16, 2010 9:54:57 AM by Hibernate Tools 3.2.0.b9

import org.apache.struts.action.ActionForm;

/**
 * Holds a single resume, including the document image
 */
public class Login extends ActionForm implements java.io.Serializable {


     protected int id;
     protected String email;
     protected String passwd;

    public Login() {
    }

	
    public Login(String email) {
        this.email = email;
    }
    public Login(String email, String passwd) {
       this.email = email;
       this.passwd = passwd;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswd() {
        return this.passwd;
    }
    
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("email").append("='").append(getEmail()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


