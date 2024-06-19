// LB 278, book 3, chapter 3
// illustrates initializers
import utilities.*;
import java.util.Scanner;

public class UseStaticInitializer  {
	public static void main(String args[])  {
		Prt.prtln("iDay = " + StaticInitializer.iDay + ", dow = " + StaticInitializer.dow);
	}
}

class StaticInitializer {
	public static int iDay;
	public static String dow;
    static   {
		iDay = 31;
		dow = "Friday";
	}
}
