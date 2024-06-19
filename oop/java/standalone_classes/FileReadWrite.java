import java.io.*;

public class FileReadWrite {
	public static void main(String args[]) {
		// We want to let the user specify which file we should open
		// on the command-line.	E.g., 'java TextIO TextIO.java'.
		if(args.length != 2) {
			System.err.println("usage: java FileReadWrite input file_name, output 
file_name");
			System.exit(1);
		}
		// We're going to read lines from 'input', which will be attached
		// to a text-file opened for reading.
		BufferedReader input = null;

		try {
			FileReader InFile = new FileReader(args[0]);
			FileWriter OutFile = new FileWriter(args[1]);
 // Open the file.
			input = new BufferedReader(InFile);
 // Tie 'input' to this file.
			PrintWriter output = new PrintWriter(OutFile,true);
			String line;
			while( (line = input.readLine()) != null ) {
				// System.out.println(line);
				output.println(line);
			}
			System.out.println("Output file is " + args[1]);
		}

		catch(FileNotFoundException x) {
 // The file may not exist.
			System.err.println("File not found: " + args[0]);
			System.exit(2);
		}
		// Now we read the file, line by line, echoing each line to
		// the terminal.

		catch(IOException x) {
			x.printStackTrace();
		}
	}
}
