// Crume, p.131
package ch04;

import java.util.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class ListQuestions extends TagSupport  {
	private String topic;
	private Iterator faqs;
	private int count;
	public void setTopic( String s ) { topic = s; }
	public String getTopic() { return topic; }

	public int doStartTag() throws JspTagException {  // process/evaluate the start tag
		Questions questions = new Questions();
		questions.setTopic( getTopic() );   // meaning this class's topic property
		Map qmap = new TreeMap( questions.getQuestions() );

		// Get an iterator for the questions
		// The iterator is an instance variable because we will access it in the doAfterBody() method
		faqs = qmap.values().iterator();
		count = 0;
		try  {
			// Write some preliminary data to the response implicit object
			pageContext.getOut().write("<h2>Questions for Topic</h2>");
			pageContext.getOut().write("\nThe number of questions in topic " + getTopic() + " is " + qmap.size() );
		}
		catch( IOException e )  {
			throw new JspTagException( "Error writing to out" );
		}
		return EVAL_BODY_INCLUDE;   // you may evaluate the body now, instead of going directly to the end tag
	}

	public int doAfterBody() throws JspTagException  {
		// Create the link for a single question
		// Each time this method is called by the page class
		// the iterator advances to the next question
		if ( faqs.hasNext() )   {
			String question = (String) faqs.next();
			String s = "<p>Question <a href=\"Questions.jsp?qid=" + getTopic() +
			           "_" + ++count + "\">" + getTopic() + "_" + count + "</a>: " +
			           question + "<p>";
			try {
				pageContext.getOut().write( s );
			}
			catch ( IOException e ) {
				throw new JspTagException( "Error writing to out" );
			}
			// Tell the page class to evaluate the body again
			return EVAL_BODY_AGAIN;
		} else {
			// faqs.next() was false, so no more questions
			return SKIP_BODY;
		}
	}

	public int doEndTag() throws JspTagException  {
		try {
			pageContext.getOut().write( "<p>Click a link to see the answer</p>");
		}
		catch( IOException e )  {
			throw new JspTagException( "Error writing to out" );
		}
		// allow it to evaluate the rest of the page
		return EVAL_PAGE;
	}
}
