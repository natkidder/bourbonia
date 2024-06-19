// Crume, p.131
package ch04;

import java.util.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class ListQuestionsInBody extends BodyTagSupport  {
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
		count = 1;

		if ( faqs.hasNext() )  {
			this.setVariables();
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}

	public int doAfterBody() throws JspTagException  {
        if ( faqs.hasNext() )  {
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
		pageContext.setAttribute( "question", faqs.next() );
		pageContext.setAttribute( "qid", topic + "_" + count );
		count++;
	}
}
