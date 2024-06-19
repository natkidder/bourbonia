import java.io.*;
import java.text.NumberFormat;

public class ChkLineLength {

     private static NumberFormat nf = NumberFormat.getNumberInstance();
     private static void prtln(String s) {
                System.out.println(s);
     }

     public static void main(String args[]) {

          // We want to let the user specify which file we should open
          // on the command-line.     E.g., 'java TextIO TextIO.java'.
          if(args.length != 3 || args[1].equalsIgnoreCase("--help") ) {
               System.err.println("usage: java ChkLineLength <file to check> <log output file name> <line length to check>");
               System.exit(1);
          }

          File fIn = new File(args[0]);
          if (! fIn.exists())     {
               System.err.println("File " + args[0] + " does not exist");
               System.exit(2);
          }

          int i = 0;     int j = 0;

          // We're going to read lines from 'input', which will be attached
          // to a text-file opened for reading.
          BufferedReader brInput = null;

          try {
               FileReader frInFile = new FileReader(args[0]);
               FileWriter fwOutFile = new FileWriter(args[1]);
               int iLen = Integer.parseInt(args[2]);
               boolean bHasVariantLen = false;

 // Open the file.

               brInput = new BufferedReader(frInFile);

 // Tie 'input' to this file.
               PrintWriter pwOutput = new PrintWriter(fwOutFile, true);
               pwOutput.println("From " + args[0] + " ...");
               String strLine;
               while( (strLine = brInput.readLine()) != null ) {
                    // System.out.println(line);
                    i++;
                    if (i % 100000 == 0) { prtln(nf.format(i) + " lines processed"); }

                    if ( strLine.length() != iLen ) {
                         pwOutput.println("Line " + i + " (below) has length: " + strLine.length());
                         pwOutput.println(strLine);
                         bHasVariantLen = true;
                         j++;
                    }
               }

			if ( bHasVariantLen ) {
				prtln("File " + args[0] + " has lines of length other than " + iLen);
				prtln("Please examine file " + args[1] + " for details");
			} else  {
				prtln("File " + args[0] + " has all lines of length " + iLen);
			}
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
