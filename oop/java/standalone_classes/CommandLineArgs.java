/* LB 697, Book 8, Chapter 1
exemplifies command-line arguments */

import utilities.*;

public class CommandLineArgs  {

	private static PrtObj p = new PrtObj();

	public static void main( String[] args )  {
		int i = 0;
		if ( args.length > 0 )  {
			for ( String s : args )  {
				System.out.println( "arg" + ++i	+ ": " + s );
			}
		} else {
			p.prtln( "no arguments passed" );
		}
	}
}
