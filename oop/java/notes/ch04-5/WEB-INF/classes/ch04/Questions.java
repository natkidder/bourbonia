// Crume, p. 108
package ch04;

import java.util.Map;
import java.util.HashMap;

public class Questions  {
	private String topic;
	private int numTopics;
	private Map questions = new HashMap();

	public void setTopic( String topic ) { this.topic = topic; }
	public String getTopic() { return this.topic; }

	public void setNumTopics( int numTopics ) { this.numTopics = numTopics; }
	public int getNumTopics() { return this.numTopics; }

	public void setQuestions( Map questions ) { this.questions = questions; }
	public Map getQuestions() { return this.questions; }

	public Questions()  {
		questions.put("1", "How do I use implicit objects?");
		questions.put("2", "How do I use the JSTL?");
		questions.put("3", "How do I use the 'empty' operator?");
		setNumTopics( questions.size() );
	}
}
