import java.io.*;

public class CreateBean {

     private static void prtln(String s) {
          System.out.println(s);
     }

     public static void main(String args[]) {

/* We want to let the user specify which file we should open on the command-line.  E.g., 'java TextIO TextIO.java'. */
		  prtln("Pls note: only the first line of the input file is read");
          if (args.length < 2) {
               System.err.println("usage: java CreateBean <input file name> <output file name>");
               System.exit(1);
          }
		  String sFileIn = args[0];
		  String sFileOut = args[1];

          int i;
          String sPosition = "";

          File fIn = new File(sFileIn);
          BufferedReader brInput = null;
          FileWriter fwOutFile;

          try {
			  String datatype; String name; String name2;
               FileReader frInFile = new FileReader(sFileIn);
               brInput = new BufferedReader(frInFile);
			   fwOutFile = new FileWriter(sFileOut);  // overwrite
               PrintWriter pwOutput = new PrintWriter(fwOutFile, true);
               String sLine;
			   // we're interested in only the first line of the input file
               if ( (sLine = brInput.readLine()) != null ) {
				   sLine = sLine.split("\\(")[1];
				   sLine = sLine.split("\\)")[0];
				   String[] params = sLine.split(",");
				   for (String param : params)  {
					   param = param.trim();
						name = param.split(" ")[1];
						pwOutput.println("		this." + name + " = " + name + ";");
				   }
				   pwOutput.println("	}");
				   for (String param : params)  {
					   param = param.trim();
						datatype = param.split(" ")[0];
						name = param.split(" ")[1];
						name2 = name.substring(0,1).toUpperCase() + name.substring(1);
						pwOutput.println("");
                    	pwOutput.println("	public " + datatype + " get" + name2 + "() { return this." + name + "; }" );
						pwOutput.println("	public void set" + name2 + "(" + datatype + " " + name + ") {");
						pwOutput.println("		this." + name + " = " + name + ";");
						pwOutput.println("	}");
				   }
               }
			   pwOutput.println("");
			   pwOutput.println("	public String toString()  {");
			   pwOutput.println("		StringBuffer buffer = new StringBuffer();");
			   pwOutput.println("	}");
			   pwOutput.println("}");
			   prtln("Output in " + sFileOut);
          }
          catch(FileNotFoundException x) {
               System.err.println("File not found: " + sFileIn);
               System.exit(2);
          }
          catch(IOException x) {
			  System.err.println("IO Error");
               x.printStackTrace();
          }
		  catch(Exception e)  {
			  e.printStackTrace();
		  }
     }
}
