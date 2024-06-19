// LB 487, book 5, chapter 2
// originated at work
import java.util.*;
import java.net.*;
import java.io.*;
import utilities.*;

public class BartClient  {

    static PrtObj p = new PrtObj();

    public static void main(String args[])  {

        try  {
	        int iPort = Integer.parseInt(args[0]); //1234;
	        p.prtln("Welcome to the Bart Client");
	        Socket cliSckt = getSocket(iPort);

            p.prtln("Connected on port " + iPort);
            Scanner scIn = new Scanner( cliSckt.getInputStream() );
            PrintWriter pwOut = new PrintWriter( cliSckt.getOutputStream(), true );  // append

            // discard the welcome message
            scIn.nextLine();

            // discard the exit instructions
            scIn.nextLine();

            // get a quote
            pwOut.println("get");
            String sQuote = scIn.nextLine();

            // disconnect from the server
            pwOut.println("bye");
            cliSckt.close();

            // write a quote on the chalkboard
            for (int i = 0; i < 20; i++)
                p.prtln(sQuote);
        }
        catch ( NumberFormatException nfe )  {
			p.prtln( nfe.toString() + ": arg must be an integer");
		}
        catch (Exception ex)  {
            ex.printStackTrace();
        }
    }

    private static Socket getSocket(int iPort)  {
        Socket cliSckt;
        String sHost;
        InetAddress iaIP;

        Scanner scIn = new Scanner(System.in);
        while (true)   {
            p.prtln("What server do you want to connect to? ");
            sHost = scIn.nextLine();
            try  {
                iaIP = InetAddress.getByName(sHost);
                cliSckt = new Socket( iaIP, iPort );
                return cliSckt;
            }
            catch (UnknownHostException uhEx)  {
                p.prtln("The host " + sHost + " is unknown.");
            }
            catch (IOException ioEx)   {
                p.prtln("network error");
            }
        }
    }
}
