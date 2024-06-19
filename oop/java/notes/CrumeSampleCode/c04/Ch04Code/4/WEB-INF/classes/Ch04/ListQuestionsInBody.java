package Ch04;

import java.util.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

public class ListQuestionsInBody extends BodyTagSupport {
  private String topic;
  private Iterator faqs;
  private int count;
  public void setTopic(String s) { topic = s; }
  public String getTopic() { return topic; }

  public int doStartTag() throws JspTagException {
    Questions questions = new Questions();
    questions.setTopic(getTopic());
    Map qmap = new TreeMap(questions.getQuestions());
    faqs = qmap.values().iterator();
    count = 1;

    if (faqs.hasNext()) {
      setVariables();
      return EVAL_BODY_INCLUDE;
    } else {
      return SKIP_BODY;
    }
  }

  public int doAfterBody() throws JspTagException {
    if (faqs.hasNext()) {
      setVariables();
      return EVAL_BODY_BUFFERED;
    } else { 
      return SKIP_BODY;
    }
  }

  public int doEndTag() throws JspTagException {
    return EVAL_PAGE;
  }

  void setVariables() {
    pageContext.setAttribute("question", faqs.next());
    pageContext.setAttribute("qid", topic + "_" + count);
    count++;
  }
}
