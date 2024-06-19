// Crume, p. 123
package ch04;

import java.util.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class SimpleList extends SimpleTagSupport  {

	private String topic;  // eg. EL
	public void setTopic( String topic ) { this.topic = topic; }
	public String getTopic() { return this.topic; }

	public void doTag() throws JspException  {
		Questions questions = new Questions();
		questions.setTopic( getTopic() );

		// Get list of questions, TreeMap will sort them by key
		Map qmap = new TreeMap( questions.getQuestions() );
		Iterator faqs = qmap.values().iterator();
		int count = 1;

		while ( faqs.hasNext() )  {
			try {
				// Store the parameters for invoke(), as attribute name-value pairs
				getJspContext().setAttribute( "qid", topic + "_" + count );
				getJspContext().setAttribute( "question", faqs.next() );
				count++;
				// Process the body
				getJspBody().invoke( null );
			}
			catch( IOException ie ) {
				throw new JspException("Exception processing body");
			}
		}
	}
}
