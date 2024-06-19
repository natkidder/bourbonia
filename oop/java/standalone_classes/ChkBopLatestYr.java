import java.io.*;
import java.text.NumberFormat;

public class ChkBopLatestYr {

     private static NumberFormat nf = NumberFormat.getNumberInstance();
     private static void prtln(String s)  {  System.out.println(s);  }
     private static void prt(String s)  {  System.out.print(s);  }

  public static void main(String args[]) {

       // We want to let the user specify which file we should open
       // on the command-line.  E.g., 'java TextIO TextIO.java'.
       if(args.length != 3) {
            System.err.println("usage: java ChkBopLatestYr <input_file_name> <output_file_name> <year_of_last_annual_obs>");
            System.exit(1);
       }

       // We're going to read lines from 'input', which will be attached
       // to a text-file opened for reading.
       BufferedReader brInput = null;

       try {
            FileReader frInFile = new FileReader(args[0]);
            FileWriter fwOutFile = new FileWriter(args[1]);
            Integer iLastYear = Integer.parseInt(args[2]);

 // Open the file.

            brInput = new BufferedReader(frInFile);

 // Tie 'input' to this file.
            PrintWriter pwOutput = new PrintWriter(fwOutFile, true);
            String strLine, strPrevLine = "", strPrevTSKey = "", strPrevAry[] = {""}, strOutLine = "";
            int iLatestYrHeader = 0, iLatestYrData = 0, iLastAnnualObs = 0;
            long iLineCnt = 0;
            boolean bWillEval = true;

            while( (strLine = brInput.readLine()) != null ) {

                 if (strLine.matches(".{13}H.*"))  {  // ASSUMES 13th position in the string array is an "H"

                    if ( bWillEval && iLatestYrHeader > 0 )  {

                         strOutLine = getLastAnnualObs(strPrevLine, strPrevTSKey, iLatestYrHeader, iLastYear);
                         if (! strOutLine.equals("") )
                              pwOutput.println(strOutLine);

                    }

                    iLatestYrHeader = 0;
                    iLatestYrData = 0;
                    strPrevLine = "";
                    strPrevTSKey = strLine.substring(0,12);
                    bWillEval = true;

                 } else if (strLine.matches("^[12][0-9][0-9][0-9]A .*"))  {  // eg. 1994A..., 2001A...{

                    iLatestYrHeader = Integer.parseInt(strLine.substring(0,4));
//                    prtln(strLine + ": " + iLatestYrHeader);  ////
                    strPrevLine = strLine;

                 } else if (strLine.matches("^[12][0-9][0-9][0-9][QM] .*"))   {

					bWillEval = false;
				 }

                 iLineCnt++;
                 if (iLineCnt % 100000 == 0)  { prtln(nf.format(iLineCnt) + " lines processed"); }

             }
             if ( bWillEval && iLatestYrHeader > 0 )  {

                  strOutLine = getLastAnnualObs(strPrevLine, strPrevTSKey, iLatestYrHeader, iLastYear);
                  if (! strOutLine.equals("") )
                        pwOutput.println(strOutLine);
             }

             prtln("Output file is " + args[1]);
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

     private static String getLastAnnualObs(String strObsLine, String strPrevTSKey, int iBaseYear, int iLastYear)  {
		int iObs;

		strObsLine = strObsLine.trim();  // to remove ending spaces from the line
// ASSUMES the observations start at position 6 and each one has 13 characters
		iObs = (strObsLine.length() - 5) / 13;

          int iLastAnnualObs = iObs + iBaseYear - 1;

          if ( iLastAnnualObs != iLastYear )
               return strPrevTSKey + ": last annual observation is " + iLastAnnualObs;
          else
               return "";
     }

}

/*
010A05...9...H S10NET ERRORS AND OMISSIONS            ALL COUNTRIES           MILLIONS OF US$      06SDEC120061113
1946A -5.60392E+10 -3.31781E+10 -5.89771E+10 -1.13708E+11  7.76405E+10  8.42692E+10 -9.13882E+10 -5.21215E+09 -3.56680E+10 -4.49880E+10  2.08236E+11  4.69307E+10
1958A -5.60392E+10 -3.31781E+10 -5.89771E+10 -1.13708E+11  7.76405E+10  8.42692E+10 -9.13882E+10 -5.21215E+09 -3.56680E+10 -4.49880E+10  2.08236E+11  4.69307E+10
1970A -5.60392E+10 -3.31781E+10 -5.89771E+10 -1.13708E+11  7.76405E+10  8.42692E+10 -9.13882E+10 -5.21215E+09 -3.56680E+10 -4.49880E+10  2.08236E+11  4.69307E+10
1982A -5.60392E+10 -3.31781E+10 -5.89771E+10 -1.13708E+11  7.76405E+10  8.42692E+10 -9.13882E+10 -5.21215E+09 -3.56680E+10 -4.49880E+10  2.08236E+11  4.69307E+10
1994A -5.60392E+10 -3.31781E+10 -5.89771E+10 -1.13708E+11  7.76405E+10  8.42692E+10 -9.13882E+10 -5.21215E+09 -3.56680E+10 -4.49880E+10  2.08236E+11  4.69307E+10
010B01...9...H S10CURRENT ACCOUNT BALANCES            ALL COUNTRIES           MILLIONS OF US$      06SDEC120061113
1994A -5.85337E+10 -5.86959E+10 -4.14175E+10  2.77098E+09 -7.46025E+10 -1.10345E+11 -1.55791E+11 -1.49143E+11 -1.28095E+11 -3.49942E+10 -7.26903E+09 -6.06100E+09
010B01A..9...H S10CURRENT ACCOUNT:CREDIT              ALL COUNTRIES           MILLIONS OF US$      06SDEC120061113
1994A  6.52820E+12  7.75380E+12  8.09627E+12  8.39529E+12  8.41948E+12  8.72485E+12  9.67953E+12  9.34050E+12  9.71407E+12  1.13240E+13  1.37503E+13  1.57351E+13
*/
