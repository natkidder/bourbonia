package rnk;

import java.util.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class ListReferencesInBody extends BodyTagSupport  {

	private ArrayList<Reference> references = new ArrayList<Reference>();

	//references = populateRefs();
	Iterator iterator;// = references.iterator();
	private String sTest;  private String sTest2;
	private int i = 0;   ////
	private Integer j = 0;

	public int doStartTag() throws JspTagException {  // process/evaluate the start tag
	    this.populateRefs();
	    iterator = references.iterator();
		if ( iterator.hasNext() )  {
			this.setVariables();
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}

	public int doAfterBody() throws JspTagException  {
        if ( iterator.hasNext() )  {
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

	void setVariables()  {
		Reference reference;
		reference = (Reference)iterator.next();
		pageContext.setAttribute( "name", reference.getName() );
		pageContext.setAttribute( "company", reference.getCompany() );
		pageContext.setAttribute( "title", reference.getTitle() );
		pageContext.setAttribute( "phoneType", reference.getPhoneType() );
		pageContext.setAttribute( "phoneNbr", reference.getPhoneNbr() );
		pageContext.setAttribute( "email", reference.getEmail() );
		pageContext.setAttribute( "relationship", reference.getRelationship() );
	}

	void populateRefs() {
		String[] refProperties;
		Reference reference;
		try {
		    sTest = "in populateRefs";
			String[] sRefs = DataStore.getReferences();
			for ( String s : sRefs )  {
				j++;  sTest = j.toString();
				refProperties = s.split( "\\|" );
				reference = new Reference();
				//System.out.println( line );  ////
				reference.setName( refProperties[0] );
				reference.setCompany( refProperties[1] );
				reference.setTitle( refProperties[2] );
				reference.setPhoneType( refProperties[3] );
				reference.setPhoneNbr( refProperties[4] );
				reference.setEmail( refProperties[5] );
				reference.setRelationship( refProperties[6] );
				this.references.add( reference );
			}
		}
		catch ( Exception e )  {
			System.out.println(e.getMessage());
		}
	}
}
