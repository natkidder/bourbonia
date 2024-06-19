import java.io.*;
import java.text.NumberFormat;
import java.util.Scanner;

public class MergeFiles {

     private static Scanner sc = new Scanner(System.in);
     private static NumberFormat nf = NumberFormat.getNumberInstance();
     private static void prtln(String s) {
         System.out.println(s);
     }
     private static void prt( String s ) {
         System.out.print(s);
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
          long iTotalLines = 0;
          String sOverwrite;

// determine if user really wishes to overwrite target file
          File fOut = new File(args[0]);
          if ( fOut.exists() ) {
              prt("Do you wish to overwrite file " + args[0] + "? (n) ");
              sOverwrite = sc.nextLine();
              if ( ! sOverwrite.equalsIgnoreCase("y") )
                  System.exit(1);
          }

// determine if all the source files exist
          for (i = 1; i < args.length-1; i++)  {
               File f = new File(args[i]);
               if ( ! f.exists() )  {
                    System.err.println("File " + args[i] + " does not exist");
                    System.exit(2);
               }
          }

// loop through each source file, adding to the the target file
         for (i = 1; i <= args.length-1; i++)  {
              if ( i == 1 )
                   sPosition = "first";
              else
                   sPosition = "not first";
              prtln( "input file: " + args[i] );
              iTotalLines = iTotalLines + concatFile(args[0], args[i], sPosition, iTotalLines);
         }
     }

     private static long concatFile(String sFileOut, String sFileIn, String sPosition, long iInitialLines)  {

          File fIn = new File(sFileIn);
          long iTotalLines = iInitialLines;
          int j = 0;

// We're going to read lines from 'input', which will be attached to a text-file opened for reading.
          BufferedReader brInput = null;
          FileWriter fwOutFile;

          try {
               FileReader frInFile = new FileReader(sFileIn);
               if ( sPosition.equals("first") )
                    fwOutFile = new FileWriter(sFileOut);  // overwrite
               else
                    fwOutFile = new FileWriter(sFileOut, true); // append

 // Open the source file.

               brInput = new BufferedReader(frInFile);

 // Tie 'input' to the output file.
               PrintWriter pwOutput = new PrintWriter(fwOutFile, true);
               String sLine;
               while( (sLine = brInput.readLine()) != null ) {
// System.out.println(line);
                    iTotalLines++;
                    if (iTotalLines % Math.pow(10,4) == 0) { prtln(nf.format(iTotalLines) + " lines processed"); }

                    pwOutput.println(sLine);

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
     return iTotalLines;
     }
}