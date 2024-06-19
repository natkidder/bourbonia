import java.io.*;

public class ParseText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// We're going to read lines from 'input', which will be attached
		// to a text-file opened for reading.
		BufferedReader input = null;

		try {
			FileReader InFile = new FileReader("in.txt");
			FileWriter OutFile = new FileWriter("c:/nat/out.txt");
 // Open the file.
			input = new BufferedReader(InFile);
 // Tie 'input' to this file.
			PrintWriter output = new PrintWriter(OutFile,true);
			String line;
			String[] fields;
			while( (line = input.readLine()) != null ) {
				// System.out.println(line);
				fields = line.split("\\:");
				output.println("First Name: " + fields[0]);
				output.println("Last Name: " + fields[1]);
				output.println("State: " + fields[2]);
				output.println("Age: " + fields[3]);
				output.println("");
			}
			System.out.println("Output file is out.txt");
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


