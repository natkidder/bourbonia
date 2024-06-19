// LB 238, book 2, chapter 8
import java.io.*;
import utilities.*;

public class SwallowingExceptions  {

	public static void main(String args[])   {

		String sFile = "c:/foo/golf.txt";
		boolean bExists = openFile( sFile );
		if ( bExists )
			Prt.prtln( sFile + " exists");
		else
			Prt.prtln( sFile + " does not exist");

	}

	private static boolean openFile( String sFile )   {
		boolean bFileOpened = false;

		try  {
			FileInputStream fis = new FileInputStream( sFile );
  //          File fTest = new File( sFile);
			bFileOpened = true;
		}

// nothing inside the catch statement; the try body handles the file not being found
		catch( FileNotFoundException fnfe )  {
		}

		return bFileOpened;
	}
}
