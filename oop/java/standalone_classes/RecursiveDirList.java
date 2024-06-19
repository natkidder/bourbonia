//LB 497, book 5, chapter 4
import java.io.File;
import java.util.Scanner;
import utilities.*;

public class RecursiveDirList   {

	static Scanner scKB = new Scanner(System.in);
	static PrtObj p = new PrtObj();
	static UtilityMedly um = new UtilityMedly();

	public static void main(String[] args)  {
		p.prtln("Welcome to the directory lister");
		do  {
			p.prt("\nEnter a path: ");
			String sPath = scKB.nextLine();
			File fDir = new File(sPath);
			if ( ! fDir.exists() || ! fDir.isDirectory() )   {
				p.prtln("\nDirectory '" + sPath + "' does not exist");
			} else  {
				p.prtln("\nListing directory tree of: ");
				p.prtln( fDir.getPath() );
				listDirectories( fDir, "  " );
			}
		} while( um.bAskAgain() );
	}

	private static void listDirectories( File fDir, String sIndent )  {
		File[] fDirs = fDir.listFiles();
		for ( File f : fDirs )   {
			if ( f.isDirectory() )   {
				p.prtln( sIndent + f.getName() );
// a method can call itself
				listDirectories( f, sIndent + "  " );
			}
		}
	}
}
