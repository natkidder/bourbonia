/* illustrates java running external shell command */
import java.util.*;
import java.io.*;
public class BadExecShellCmd
{
    public static void main(String args[])
    {
		Thread rp = new RunProc();
		rp.start();

    }
}

class RunProc extends Thread  {

	public void run()  {
		try {
		     Runtime rt = Runtime.getRuntime();
		     Process proc = rt.exec("\"c:\\program files\\microsoft office\\office\\excel.exe\"  \"c:\\foo\\golf.csv\"");
		     int exitVal = proc.exitValue();
		     System.out.println("Process exitValue: " + exitVal);
		}
		catch ( IllegalThreadStateException itse )  {
			// asynchronous process never exited;
		}
		catch ( Exception e )      {
		     e.printStackTrace();
           }
	}
}

