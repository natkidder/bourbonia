// LB 402, book 4, chapter 2
import utilities.*;
import java.util.Arrays;

public class CompareArrays  {

	static PrtObj p = new PrtObj();

	public static void main(String args[])  {
		int iArrayOriginal[] = { 71, 61, 57, 67, 53 };

		int iArrayCopy[] = Arrays.copyOf( iArrayOriginal, 5 );

		Arrays.sort( iArrayCopy );

// compare unidimensional arrays
		if ( Arrays.equals( iArrayOriginal, iArrayCopy ) )
			p.prtln("original array was sorted");
		else
			p.prtln("original array was NOT sorted");

		printIntArray(iArrayOriginal);

// now compare multidimensional arrays
		int iArray11[][] = { {1,1}, {2,2} };
		int iArray12[][] = { {1,2}, {2,2} };

		if ( Arrays.deepEquals( iArray11, iArray12 ) )
			p.prtln("multidimensional arrays equal");
		else
			p.prtln("multidimensional arrays NOT equal");
	}
	static void printIntArray( int iArray[] )  {
		for ( int i : iArray )  {
			p.prt(i + " ");
		}
		p.prtln("");
	}
}
