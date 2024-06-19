import java.util.*;
import java.io.*;

public class ObjectSandbox {

	public StringBuilder sb1 = new StringBuilder();
	public StringBuilder sb2 = sb1;
	
    public Calendar setCal(Boolean isCreating)  {
    	Calendar cal = null;
    	if (isCreating) {
    		cal = Calendar.getInstance();
    	}
    	return cal;
    }
    
    public int getDayOfWeek()  {
    	Calendar cal = this.setCal(true);
    	return cal.get(cal.DAY_OF_WEEK);
    }
    
    public long getDelay()  {
    	long timeInMillis_1 = Calendar.getInstance().getTimeInMillis();
        try {
            for (int i = 0; i < 50; i++) {
				FileWriter fout = new FileWriter("textfile.txt");
				PrintWriter fileout = new PrintWriter(fout, true);
				fileout.close();
				fout.close();
				// Open the file that is the first
				// command line parameter
				FileInputStream fstream = new FileInputStream("textfile.txt");
				// Get the object of DataInputStream
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(
						new InputStreamReader(in));
				String strLine;
				//Read File Line By Line
				while ((strLine = br.readLine()) != null) {
					// Print the content on the console
					System.out.println(strLine);
				}
				//Close the input stream
				in.close();
			}
            } catch (Exception e){//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
    	long timeInMillis_2 = Calendar.getInstance().getTimeInMillis();
    	return timeInMillis_2 - timeInMillis_1;
    	
    }
    
    public void provokeException() throws IOException {
    	FileInputStream fstream = new FileInputStream(Calendar.getInstance().toString());
    }
    
    public double getDbl_1()  {
    	double dbl1 = Math.PI / 0.3542189;
    	return dbl1;
    }
    
    public double detDbl_2()  {
    	double dbl2 = Math.PI / 0.3542189;
    	return dbl2;
    }

}
