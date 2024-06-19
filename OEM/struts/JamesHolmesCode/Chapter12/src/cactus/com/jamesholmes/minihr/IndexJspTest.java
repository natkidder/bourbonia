package com.jamesholmes.minihr;

import org.apache.cactus.JspTestCase;

import com.jamesholmes.minihr.security.User;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;

public class IndexJspTest extends JspTestCase {
	
	public IndexJspTest(String theName) {
		super(theName);
	}

	public void testAdministratorAccess() throws Exception {
		User user = new User("bsiggelkow","Bill", "Siggelkow", "thatsme",
		                     new String[] {"administrator"});
    session.setAttribute("user", user);
    pageContext.forward("/index.jsp");
  }

  public void endAdministratorAccess(WebResponse response) throws Exception {
		// verify that the login form is not displayed
		assertNull("Login form should not have rendered", response.getFormWithName("loginForm"));

    //verify that the proper links link are
    WebLink[] links = response.getLinks();
    assertTrue("First link is admin/add.jsp", links[0].getURLString().startsWith("/test/admin/add.jsp"));
		assertTrue("Second link is search.jsp", links[1].getURLString().startsWith("/test/search.jsp"));    
	}
}
