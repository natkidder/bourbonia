import java.io.*;

class AllLineStdLen  {

   public static void main(String args[])  {
	  if (args.length < 2) {
		  System.io.println("arg1: file to examine, arg2: standard line length");
		  System.exit(1);
	  }

	  String sFile = args[0];
	  Integer iStdLen = args[1];
	  Integer i = 0;

      try  {

		// Open the file that is the first command line parameter

		FileInputStream fstream = new FileInputStream(sFile);

		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;

		//Read File Line By Line
		while ((strLine = br.readLine()) != null) 	{
			// Print the content on the console
			if (strLine.length != iStdLen) {
				i++;
			}
		}

		if (i > 0) {
			System.out.println("File " + sFile + " has " + i.toString + " lines not of length " + iStdLen.toString);
		}

		//Close the input stream
		in.close();
	  }

	  catch (Exception e)  {            //Catch exception if any
			System.err.println("Error: " + e.getMessage());
	  }

   }
}
