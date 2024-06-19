package Ch04;

import java.util.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class SimpleList extends SimpleTagSupport {
  private String topic;
  public void setTopic(String s) { topic = s; }
  public String getTopic() { return topic; }

  public void doTag() throws JspException {
	Questions questions = new Questions();
	questions.setTopic(getTopic());

	// Get list of questions, TreeMap will sort them by key
	Map qmap = new TreeMap(questions.getQuestions());
	Iterator faqs = qmap.values().iterator();
	int count = 1;

	while (faqs.hasNext()) {
	  try {
	  	getJspContext().setAttribute("qid", topic + "_" + count);
	  	getJspContext().setAttribute("question", faqs.next());
		count++;
		// Process the body
		getJspBody().invoke(null);
	  } catch (IOException e) {
		throw new JspException("Exception processing body");
	  }
	}
  }
}
