import java.util.Scanner;
import java.text.NumberFormat;

public class StaticVsInstantiated   {

	public static void prtln(String s) { System.out.println(s);  }
	public static void prt(String s)  { System.out.print(s);  }

	static Scanner sckb = new Scanner(System.in);

	public static void main(String args[])  {
        Bearing brng = new Bearing("North");
        this.prtln(Bearing.getOppBearing('N'));
	}
}
class Bearing  {
	private String sBearing;
	public Bearing(String sBearing)  {
		this.sBearing = sBearing;
	}
	public void setBearing(String sBearing)  {
		String sBearings = "NorthSouthEastWest";
		if ( sBearings.indexOf(sBearing) > 0 )
		    this.sBearing = sBearing;
		else ;
	}
	public String getBearing()  {
		return this.sBearing;
	}
	public static String getOppBearing(char cBearing)  {
		String sOppBearing;
		switch (cBearing)  {
			case 'N':
				sOppBearing = "South";
				break;
			case 'S':
				sOppBearing = "North";
				break;
			case 'E':
				sOppBearing = "West";
				break;
			case 'W':
				sOppBearing = "East";
				break;
			default:
				sOppBearing = "";
		}
		return sOppBearing;
	}
}
