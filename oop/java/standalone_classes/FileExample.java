/* LB 694, Book 8, Chapter 1
exemplifies both files and directories */

import utilities.*;
import java.io.*;
import java.util.Scanner;

public class FileExample {

	static PrtObj p = new PrtObj();
	static Scanner sckb = new Scanner( System.in );
	static File fileTest;

	public static void main( String[] args )  {
		p.prt( "Enter a full file path: " );
		String filename = sckb.nextLine();
		fileTest = new File( filename );
		try  {
			if ( ! fileTest.exists() )  {
				p.prtln( "file " + filename + " does not exist, can create using createNewFile()" );
			} else {
				p.prtln( "File " + filename + " separator: " + fileTest.separator );
				p.prtln( "File " + filename + " canRead: " + fileTest.canRead() );
				p.prtln( "File " + filename + " canWrite: "  + fileTest.canWrite() );
				p.prtln( "File " + filename + " getCanonicalPath: " + fileTest.getCanonicalPath() );
				p.prtln( "File " + filename + " getName: " + fileTest.getName() + "\n" );
				p.prtln( "File " + filename + " getParent: " + fileTest.getParent() );
				p.prtln( "File " + filename + " getParentFile-getName: " + fileTest.getParentFile().getName() );
				p.prtln( "File " + filename + " isDirectory: " + fileTest.isDirectory() );
				p.prtln( "File " + filename + " isFile: " + fileTest.isFile() );
				p.prtln( "File " + filename + " isHidden " + fileTest.isHidden() + "\n" );
				p.prtln( "File " + filename + " lastModified: " + fileTest.lastModified() );
				p.prtln( "File " + filename + " length: " + fileTest.length() );
				p.prtln( "File " + filename + " toString: " + fileTest.toString() );
				p.prtln( "The root directory(s) on this system: " );
				File[] filesRoot = File.listRoots();
				for ( File f : filesRoot )  {
					p.prtln( f.getName() );
				}
			}

			p.prt( "Enter a directory: " );
			filename = sckb.nextLine();
			fileTest = new File( filename );
			if ( fileTest.exists() )  {
				if ( fileTest.isDirectory() )  {
					String[] dirContents = fileTest.list();
					p.prtln( "Contents of the list() method: " );
// can make this a separate method that calls itself for listing the directory tree
					for ( String s : dirContents )  {
						p.prtln( "\t" + s );
					}
					File[] fileList = fileTest.listFiles();
					p.prtln( "Contents of the listFiles-getName & length methods" );
					for ( File f : fileList )  {
						p.prtln( "\t" + f.getName() + "\t" + f.length() );
					}
				} else {
					p.prtln( filename + " is not a directory " );
				}
			} else {
				p.prtln( filename + " does not exist, can create using mkdirs()" );
			}
		}
		catch ( IOException ioe )  {
			p.prtln( ioe.toString() + ": perhaps the file was unsuccessfully created" );
		}
	}
}
