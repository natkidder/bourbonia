// LB 236, book 2, chapter 8
import java.io.*;
import utilities.*;

public class FileException2   {

	public static void main(String args[])   {
		openFile( "C:/foo/test.txt" );
	}

	public static void openFile(String sFile)   {
		try  {
			File fTest = new File( sFile );
			if ( fTest.exists() )  {
				Prt.prtln("File " + sFile + " exists and has a size of " + fTest.length() +
				          " and has a canonical path of " + fTest.getCanonicalPath() );
				FileReader frTest = new FileReader(fTest);
				BufferedReader brTest = new BufferedReader(frTest);
			} else {
				Prt.prtln("File " + sFile + " does not exist");
			}
		}
		catch( FileNotFoundException fnfe )  {
			Prt.prtln("File " + sFile + " not found");
		}
		catch( java.io.IOException ioe )   {
			Prt.prtln( ioe.toString() + ": cannot read file " + sFile );
		}
	}
}
