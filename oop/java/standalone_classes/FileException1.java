// LB 236, book 2, chapter 8
// NOTE: This program will compile; FileInputStreams must catch the FileNotFoundException class

import java.io.*;

public class FileException1  {

	public static void main(String[] args)   {
		String sFile = "C:/foo/test.txt";
		try {
			openFile( sFile );
		}
		catch (FileNotFoundException fnfe)  {
			System.out.println(fnfe.toString() + ": " + sFile + " not found");
		}
	}

	public static void openFile(String sFile)  throws FileNotFoundException {
		FileInputStream fis = new FileInputStream( sFile );
	}
}
