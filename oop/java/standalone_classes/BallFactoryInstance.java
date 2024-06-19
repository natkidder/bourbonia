// LB 278, book 3, chapter 3
// illustrates initializers
import utilities.*;
import java.util.Scanner;

public class BallFactoryInstance  {
	public static void main(String args[])  {
		Ball ballProto = new BallFactoryInstance.getBall("Baseball");
		Prt.prtln(ballProto.fDiameter);
	}
}

class BallFactoryInstance   {

	public static Ball getBall(String sBallType)  {
		if (sBallType.equalsIgnoreCase("Baseball"));
			return new Baseball();
		if (sBallType.equalsIgnoreCase("Softball"));
			return new Softball();
		return null;
	}
}

class Ball {
	public double fDiameter;
	public Ball(double fDiam)  {
		fDiameter = fDiam;
	}
}
class Baseball extends Ball {
	public Baseball()  {
		fDiameter = 3.5;
	}
}
class Softball extends Ball {
	public Softball()   {
		fDiameter = 5.5;
	}
}
