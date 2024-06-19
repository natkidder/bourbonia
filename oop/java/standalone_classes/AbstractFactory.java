// LB 303, book 3, chapter 3
// illustrates initializers
import utilities.*;
import java.util.Scanner;

public class AbstractFactory  {
	public static void main(String args[])  {
		Ball ballProto = getBall("Baseball");
		Prt.prtln("Name: " + ballProto.getName());
		Prt.prtln("Diameter: " + ballProto.fDiameter);
		Prt.prtln("Pitched: " + ballProto.pitch());
	}
	public static Ball getBall(String sBallType)  {
		if (sBallType.equalsIgnoreCase("Baseball"))
			return new Baseball();
		else if (sBallType.equalsIgnoreCase("Softball"))
			return new Softball();
		return null;
	}
}

class Ball {
	public double fDiameter;
	protected String name;
	public Ball()  {
		name = "ball";
		fDiameter = 1;
	}
	protected String pitch() {
		return "generic: indeterminate";
	}
	protected String getName()  {
		return this.name;
	}
}
class Baseball extends Ball {
//	private static String name = "baseball";
	public Baseball()  {
		name = "baseball";
		fDiameter = 3.5;
	}
	public String pitch()  {
		return "overhanded";
	}
}
class Softball extends Ball {
//	private static String name = "softball";
	public Softball()   {
		name = "softball";
		fDiameter = 5.5;
	}
	public String pitch()  {
		return "underhanded";
	}
}
