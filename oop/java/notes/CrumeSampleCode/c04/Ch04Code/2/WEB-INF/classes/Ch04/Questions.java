package Ch04;

import java.util.Map;
import java.util.HashMap;

public class Questions {
  private String topic;
  private int numTopics;
  private Map questions = new HashMap();

  public String getTopic() { return topic; }
  public void setTopic(String t) { topic = t; }

  public int getNumTopics() { return numTopics; }
  public void setNumTopics(int n) { numTopics = n; }

  public Map getQuestions() { return questions; }
  public void setQuestions(Map m) { questions = m; }

  public Questions() {
	questions.put("1", "How do I use implicit objects?");
	questions.put("2", "How do I use the JSTL?");
	questions.put("3", "How do I use the 'empty' operator?");
	setNumTopics(questions.size());
  }
}