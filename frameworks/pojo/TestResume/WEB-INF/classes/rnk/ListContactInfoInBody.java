// Crume, p.131
package rnk;

import java.util.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class ListContactInfoInBody extends BodyTagSupport  {

	private Integer i = 0;

	public int doStartTag() throws JspTagException {  // process/evaluate the start tag
		if ( i < 1 )  {
			this.setVariables();
			i++;
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}

	public int doAfterBody() throws JspTagException  {
        if ( i < 1 )  {
			this.setVariables();
			return EVAL_BODY_BUFFERED;
		} else {
			return SKIP_BODY;
		}
	}

	public int doEndTag() throws JspTagException  {
		// allow it to evaluate the rest of the page
		return EVAL_PAGE;
	}

	private void setVariables()  {
		ContactInfo contactInfo = populateContactInfo();
		pageContext.setAttribute( "street", contactInfo.getStreet() );
		pageContext.setAttribute( "city", contactInfo.getCity() );
		pageContext.setAttribute( "state", contactInfo.getState() );
		pageContext.setAttribute( "zip", contactInfo.getZip() );
		pageContext.setAttribute( "homePhone", contactInfo.getHomePhone() );
		pageContext.setAttribute( "cellPhone", contactInfo.getCellPhone() );
		pageContext.setAttribute( "textPhone", contactInfo.getTextPhone() );
		pageContext.setAttribute( "email", contactInfo.getEmail() );
	}

	private ContactInfo populateContactInfo() {
		String[] ciProperties;
		ContactInfo contactInfo;
		String sContactInfo = DataStore.getContactInfo();
		ciProperties = sContactInfo.split( "\\|" );
		contactInfo = new ContactInfo();
		contactInfo.setStreet( ciProperties[0] );
		contactInfo.setCity( ciProperties[1] );
		contactInfo.setState( ciProperties[2] );
		contactInfo.setZip( ciProperties[3] );
		contactInfo.setHomePhone( ciProperties[4] );
		contactInfo.setCellPhone( ciProperties[5] );
		contactInfo.setTextPhone( ciProperties[6] );
		contactInfo.setEmail( ciProperties[7] );
		return contactInfo;
	}
}
