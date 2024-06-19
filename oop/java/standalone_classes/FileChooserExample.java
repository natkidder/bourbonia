/* LB 694, Book 8, Chapter 1
exemplifies both files and directories */

import utilities.*;
import java.io.*;
import javax.swing.*;

public class FileChooserExample extends JFrame {

	static PrtObj p = new PrtObj();
	static File fileTest;
	static String filename;

	public static void main( String[] args )  {
		new FileChooserExample();
	}

	public FileChooserExample() {
		p.prt( "Enter a full file path: " );

		//fileTest = new File();
		JFileChooser fileChoose = new JFileChooser();
		fileChoose.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES );
		int iResult = fileChoose.showOpenDialog(this);
		if ( iResult == JFileChooser.APPROVE_OPTION )
			fileTest = fileChoose.getSelectedFile();

		try  {
			if ( ! fileTest.exists() )  {
				p.prtln( "file does not exist, can create using createNewFile()" );
			} else {
				filename = fileTest.getName();
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

			//p.prt( "Enter a directory: " );

			iResult = fileChoose.showOpenDialog(this);
			if ( iResult == JFileChooser.APPROVE_OPTION )
				fileTest = fileChoose.getSelectedFile();

			if ( fileTest.exists() )  {
				filename = fileTest.getName();
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
