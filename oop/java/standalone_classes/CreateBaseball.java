// works with L&B Ball.java & Baseball.java
import utilities.*;

public class CreateBaseball   {

	public static void main(String args[])   {
		Ball bball = new Baseball();
		Prt.prtln("Baseball weight == " + bball.getWeight().toString());
	}
}
