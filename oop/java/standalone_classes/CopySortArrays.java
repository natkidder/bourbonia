// LB 400, book 4, chapter 2
import utilities.*;
import java.util.Arrays;

public class CopySortArrays  {

	static PrtObj p = new PrtObj();

	public static void main(String args[])  {
		int iArrayOriginal[] = {71, 61, 57, 67, 53};

		int iArrayCopy[] = Arrays.copyOf( iArrayOriginal, 3);

		Arrays.sort( iArrayCopy );

		printIntArray(iArrayCopy);
	}

	static void printIntArray( int iArray[] )  {
		for ( int i : iArray )  {
			p.prt(i + " ");
		}
		p.prtln("");
	}
}
