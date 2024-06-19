import java.io.*;
import java.text.NumberFormat;

public class ConcatCompareXML {

     private static NumberFormat nf = NumberFormat.getNumberInstance();
     private static void prtln(String s) {
          System.out.println(s);
     }

     public static void main(String args[]) {

/* We want to let the user specify which file we should open
 on the command-line.  E.g., 'java TextIO TextIO.java'. */
          if (args.length < 3) {
               System.err.println("usage: java ConcatCompareXML <output file name> <input file name 1> <input file name 2> ...");
               System.exit(1);
          }

          int i;
          String sPosition = "";

          for (i = 1; i < args.length-1; i++)  {
               File f = new File(args[i]);
               if ( ! f.exists() )  {
                    System.err.println("File " + args[i] + " does not exist");
                    System.exit(2);
               }
          }

         for (i = 1; i <= args.length-1; i++)  {
              if ( i == 1 )
                   sPosition = "first";
              else if ( i == args.length - 1 )
                   sPosition = "last";
              else
                   sPosition = "middle";
              prtln("input file: " + args[i] + " i: " + i + " sPosition: " + sPosition); ////
              concatFile(args[0], args[i], sPosition);
         }
     }

     private static void concatFile(String sFileOut, String sFileIn, String sPosition)  {
          File fIn = new File(sFileIn);
          int i = 0;  int j = 0;

// We're going to read lines from 'input', which will be attached
// to a text-file opened for reading.
          BufferedReader brInput = null;
          FileWriter fwOutFile;

          try {
               FileReader frInFile = new FileReader(sFileIn);
               if ( sPosition.equals("first") )
                    fwOutFile = new FileWriter(sFileOut);  // overwrite
               else
                    fwOutFile = new FileWriter(sFileOut, true); // append

 // Open the file.

               brInput = new BufferedReader(frInFile);

 // Tie 'input' to this file.
               PrintWriter pwOutput = new PrintWriter(fwOutFile, true);
               String sLine;
               while( (sLine = brInput.readLine()) != null ) {
// System.out.println(line);
                    i++;
                    if (i % 100000 == 0) { prtln(nf.format(i) + " lines processed"); }

/* ASSUMES the header lines of the compare XML file take up no more than 20 lines, but the file itself is longer than
20 lines */
                    if ( sPosition.equals( "first" ) ) {
                         if ( i < 20 || sLine.matches("^[0-9].*") ) {  // print only the first tag lines
                              pwOutput.println(sLine);
                              j++;
                         }
                    } else if ( sPosition.equals( "middle" ) )  {  // print no tag lines
                         if ( sLine.matches("^[0-9].*") ) {
//                             prtln(sLine); ////
                             pwOutput.println(sLine);
                              j++;
                         }
                    } else if ( sPosition.equals( "last" ) )  {
                         if ( i > 20 || sLine.matches("^[0-9].*") ) { // print only the last tag lines
                              pwOutput.println(sLine);
                              j++;
                         }
                    }
               }
          }

          catch(FileNotFoundException x) {
 // The file may not exist.
               System.err.println("File not found: " + sFileIn);
               System.exit(2);
          }
    // Now we read the file, line by line, echoing each line to
    // the terminal.

          catch(IOException x) {
               x.printStackTrace();
          }
     }
}