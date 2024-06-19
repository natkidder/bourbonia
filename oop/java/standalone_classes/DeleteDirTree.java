//LB 497, book 5, chapter 4
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;

public class DeleteDirTree   {

	static Scanner scKB = new Scanner(System.in);
	static ArrayList<String> al = new ArrayList<String>();
	
	public static void main(String[] args)  {
		System.out.println("DANGER! DANGER!  THIS DELETES EVERY FILE IN A TREE!!");
		al.clear();
		System.out.print("\nEnter a path: ");
		String sPath = scKB.nextLine();
		if (deleteDir(sPath))  {
			System.out.println("Tree " + sPath + " deleted");
		} else {
			System.out.println("Tree " + sPath + " does not exist");
		}
	}

	private static boolean deleteDir( String path )  {
		File fDir = new File( path );
		if ( ! (fDir.exists() && fDir.isDirectory()) ) {
			return false;
		} else {
			al.add( path );
			listDirectories( fDir, al );
			ListIterator iterator = al.listIterator();
			while (iterator.hasNext()) { iterator.next(); }  // go to end
			while (iterator.hasPrevious())  {
				String s = (String) iterator.previous();
				File f = new File(s);
				f.delete();
			}
			return true;
		}
	}

	private static void listDirectories( File fDir, ArrayList<String> al )  {
		File[] fDirs = fDir.listFiles();
		if (fDirs != null)  {
			for ( File f : fDirs )   {
				al.add(f.getAbsolutePath());
// a method can call itself
				listDirectories( f, al );
			}
		}
	}
}
