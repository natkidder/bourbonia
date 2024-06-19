// LB 484, book 5, chapter 2
// originated at work
import java.util.*;
import java.net.*;
import java.io.*;
import utilities.*;
import java.lang.reflect.Array;

public class BartServer  {

    static PrtObj p = new PrtObj();

    public static void main(String[] args)   {

		if (Array.getLength(args) < 1)
			System.exit(1);

        int iPort = Integer.parseInt(args[0]);   //1234;

        BartQuote bq = new BartQuote();

        try   {
            p.prtln("BartServer 1.0");
            p.prtln("Listening on port: " + iPort);
            ServerSocket ssckt = new ServerSocket( iPort );
            Socket sckt;
            sckt = ssckt.accept();

            String sClient;

            sClient = sckt.getInetAddress().toString();
            p.prtln("Connected to: " + sClient);

            Scanner scIn;
            scIn = new Scanner(sckt.getInputStream());
            PrintWriter pwOut;
            pwOut = new PrintWriter(sckt.getOutputStream(), true);

            pwOut.println("Welcome to BartServer 1.0");
            pwOut.println("Enter GET to get a quote or BYE to exit");

            while (true)  {
                String sInput = scIn.nextLine();
                if ( sInput.equalsIgnoreCase("bye") )
                    break;
                else if ( sInput.equalsIgnoreCase("get") )  {
                    pwOut.println(bq.getQuote());
                    p.prtln("Serving " + sClient);
                }  else  {
                    pwOut.println("Huh?");
                }
            }
            pwOut.println("So long, suckers.");
            sckt.close();
            p.prtln("Closed connection to " + sClient);
        }
        catch ( NumberFormatException nfe )  {
			p.prtln( nfe.toString() + ": arg1 must be an integer" );
		}
        catch (Exception ex)  {
            ex.printStackTrace();
        }
    }
}
