// LB 285, book 3, chapter 4
// illustrates simple inheritance

public class Ball  {

	private double fWeight;

	protected Double getWeight()  {

		return this.fWeight;
	}
	protected void setWeight(double fWeight)   {

		System.out.println("in Ball.setWeight");  ////
		this.fWeight = fWeight;
	}
}

/*
boundary not allowed, as Baseball is in same file as Ball, must be commented out as there a separate Ball.java file
*/
/*
class Baseball extends Ball  {

	public Baseball()   {

		setWeight(5.125);
	}
}
*/
