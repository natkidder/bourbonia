import java.util.Scanner;
import java.text.NumberFormat;

public class TestConcepts   {

	public static void prtln(String s) { System.out.println(s);  }
	public static void prt(String s)  { System.out.print(s);  }

	static Scanner sckb = new Scanner(System.in);

	public static void main(String args[])  {
		int i = 90, j = 99;
		i = j++ * 2;
		prtln(""+i);
		char b = 3;
		switch (b) {
			case 3:
				prtln("true");
		}
		String s = "Billy dog";
		i = s.indexOf("m");
		prtln(""+i);
		Bearing.prtln("sss");

        Bearing brng = new Bearing();
/*      Velocity vlcty = (Velocity)brng;
        brng.setBearing("South");
        prtln(Bearing.degreesToBearing(i*3));
*/
	}
}

class Bearing  {

	public TestConcepts ts = new TestConcepts();
	protected String sBearing;
    String sInit = "initializing a bearing";
    public String s1 = "BearingInstanceVar";
	public void prtln(String s) { System.out.println(s + ".");  }

	public Bearing()  {
		this.sBearing = "";
		prtln(s1);
	}

	public Bearing(String sBearing)  {
		String sBearings = "NorthSouthEastWest";
		if ( sBearings.indexOf(sBearing) > 0 )
			this.sBearing = sBearing;
	}

	public void setBearing(String sBearing)  {
		String sBearings = "NorthSouthEastWest";
		if ( sBearings.indexOf(sBearing) > 0 )
		    this.sBearing = sBearing;
		else ;
		this.prtln("go");
	}

	public String getBearing()  {
		return this.sBearing;
	}

	public static String degreesToBearing(int iDegrees)  {
		String sBearing;
		switch (iDegrees)  {
			case 0:
				sBearing = "North";
				break;
			case 90:
				sBearing = "East";
				break;
			case 180:
				sBearing = "South";
				break;
			case 270:
				sBearing = "West";
				break;
			default:
				sBearing = "";
		}
		return sBearing;
	}
}

class Velocity extends Bearing  {

	private double fSpeed;

	public Velocity()  {
		this.sBearing = "North";
		this.fSpeed = 0.0;
	}

	public Velocity(String sBearing, double fSpeed)  {
		this.setBearing(sBearing);
		setSpeed(fSpeed);
	}

	public void setBearing(String sBearing)  {
		this.sBearing = sBearing;
	}
	public void setSpeed(double fSpeed)  {
		this.fSpeed = fSpeed;
	}
	public double getSpeed()  {
		return this.fSpeed;
	}

	public String getAttr()  {
		return this.getSpeed() + ", " + this.getBearing();
	}
}
