import java.io.*;
import java.text.NumberFormat;

public class ProduceRangeOfLines {

     private static NumberFormat nf = NumberFormat.getNumberInstance();
     private static void prtln(String s)  {  System.out.println(s);  }
     private static void prt(String s)  {  System.out.print(s);  }

     public static void main(String args[]) {

          // We want to let the user specify which file we should open
          // on the command-line.     E.g., 'java TextIO TextIO.java'.
          if(args.length != 4) {
               System.err.println("usage: java ProduceRangeOfLines <input file name> <output file_name> <start line number> <number of lines to return>");
               System.exit(1);
          }

          File fIn = new File(args[0]);
          if (! fIn.exists())     {
               System.err.println("File " + args[0] + " does not exist");
               System.exit(2);
          }

          long i = 0;     long j = 0;
          Long iStartLine = Long.parseLong(args[2]);     Long iNbrLines = Long.parseLong(args[3]);

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
                    if (i % 10000 == 0)  { prtln(nf.format(i) + " lines processed"); }

                    if ( i >= iStartLine && j <= iNbrLines ) {
                         pwOutput.println(strLine);
                         j++;
                    } else if ( i > iStartLine + iNbrLines ) {
                         break;
                    }
               }
               System.out.println("Output file is " + args[1] );
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
