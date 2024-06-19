// LB 407, book 4, chapter 3
import utilities.PrtObj;
import java.util.*;

public class ArrayListExample  {

	static PrtObj p = new PrtObj();
	static Scanner sc = new Scanner(System.in);
	static String sResp = "";

	public static void main(String args[])  {
/* <Object> can be any object, including user-defined */
		ArrayList<String> alSigns = new ArrayList<String>();

		alSigns.add("Cheltenham Circle");
		alSigns.add("Ashburn Farm Parkway");
		alSigns.add("Parkhurst Plaza");

		alSigns.add(1, "Ashburn Village Blvd.");

		p.prtln("1");
		for (int i = alSigns.size()-1; i >= 0; i--)
			p.prtln( (String)alSigns.get(i) );

		p.prtln("2");
		for ( String sSign : alSigns )
			p.prtln(sSign);

		p.prtln("3");
		for ( String sSign : alSigns )  {
			int i = alSigns.indexOf(sSign);
			p.prtln("Item " + i + " is " + sSign);
		}

		p.prt("\nEnter a letter or number ");  sResp = sc.next();

		p.prtln("4");
		printArrayList(alSigns);

		p.prtln("5");
		Iterator iterSigns = alSigns.iterator();
		while ( iterSigns.hasNext() )  {
			String sSign = (String)iterSigns.next();
			p.prtln(sSign);
		}

		p.prtln("5");
		alSigns.set(1, "AVB");
		printArrayList(alSigns);

		p.prtln("6");
/* can also use the value eg. "AVB" as the remove argument */
		alSigns.remove(2);
		printArrayList(alSigns);

		p.prtln("7");
		alSigns.clear();
		p.prtln("ArrayList now has " + alSigns.size() + " elements");
	}

	private static void printArrayList( ArrayList<String> al )  {
		for ( String s : al )
			p.prtln(s);
	}

}
