import java.io.*;
import java.text.NumberFormat;

public class ProduceCdromHeaderLines {

     private static NumberFormat nf = NumberFormat.getNumberInstance();
     private static void prtln(String s)  {  System.out.println(s);  }
     private static void prt(String s)  {  System.out.print(s);  }

     public static void main(String args[]) {

          // We want to let the user specify which file we should open
          // on the command-line.     E.g., 'java TextIO TextIO.java'.
          if(args.length != 2) {
               System.err.println("usage: java ProduceCdromHeaderLines <input file name> <output file name>");
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

 // Open the file.

               brInput = new BufferedReader(frInFile);

 // Tie 'input' to this file.
               PrintWriter pwOutput = new PrintWriter(fwOutFile, true);
               String strLine;
               while( (strLine = brInput.readLine()) != null ) {
                    // System.out.println(line);
                    i++;
                    if (i % 100000 == 0)  { prtln(nf.format(i) + " lines processed"); }
// ASSUMES the header lines have an H in the 13th position
                    if ( strLine.substring(13,14).equals("H") ) {
                         pwOutput.println(strLine);
                         j++;
                    }
               }
               System.out.println("Output file is " + args[1] + ", with " + i + " input lines and " + j + " output lines");
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
