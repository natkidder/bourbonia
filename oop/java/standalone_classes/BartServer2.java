// LB 490, book 5, chapter 2
// originated at work
import java.util.*;
import java.net.*;
import java.io.*;
import utilities.*;

public class BartServer2  {

    static PrtObj p = new PrtObj();

    public static void main(String[] args)   {
        int iPort = 1234;
        BartQuote bqBart = new BartQuote();

        try  {
            p.prtln("BartServer 2.0");
            p.prtln("Listening on port " + iPort);
            ServerSocket SvrSckt = new ServerSocket(iPort);

            while (true)   {
                Socket CliSckt = SvrSckt.accept();
                p.prtln("Connection now established.");
                Thread thrdBart = new Thread( new BartThread(CliSckt, bqBart) );
                thrdBart.start();
            }
        }
        catch (Exception ex)  {
            p.prtln("System exception!");
        }
    }
}

class BartThread implements Runnable  {

    private Socket CliSckt;
    private BartQuote bqBart;
    private static PrtObj p = new PrtObj();

    public BartThread(Socket CliSckt, BartQuote bqBart)    {
        this.CliSckt = CliSckt;
        this.bqBart = bqBart;
    }

    public void run()  {
        String sClient = CliSckt.getInetAddress().toString();
        p.prtln("Connected to " + sClient);
        try   {
            Scanner scIn = new Scanner(CliSckt.getInputStream());
            PrintWriter pwOut;
            pwOut = new PrintWriter(CliSckt.getOutputStream(), true);

            pwOut.println("Welcome to the Bart Server");
            pwOut.println("Enter BYE to exit.");

            while (true)  {
                String sInput = scIn.nextLine();
                if (sInput.equalsIgnoreCase("bye"))
                    break;
                else if (sInput.equalsIgnoreCase("get"))  {
                    pwOut.println(bqBart.getQuote());
                    p.prtln("Serving " + sClient);
                }
                else
                    pwOut.println("Huh?");
            }
            pwOut.println("So long, suckers!");
            CliSckt.close();
        }
        catch (Exception ex)  {
            p.prtln("Closed connection to " + sClient);
        }
    }
}
