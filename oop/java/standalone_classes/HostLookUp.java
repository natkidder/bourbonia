// LB 477, book 5, chapter 2
// originated at work
import java.util.Scanner;
import java.net.*;
import utilities.*;

public class HostLookUp  {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)  {
        Prt.prtln("Welcome to the IP lookup application");
        String sHost;

        do  {
            Prt.prt("\nEnter a host name: ");
            sHost = sc.nextLine();
            try   {

                InetAddress[] inaAddresses = InetAddress.getAllByName(sHost);
                for ( InetAddress inaAddress : inaAddresses )
                    Prt.prtln( inaAddress.toString() );
            }
            catch ( UnknownHostException uhe )   {
                Prt.prtln( uhe.toString() + ": Unknown host" );
            }
        } while ( bDoAgain() );
    }

    private static boolean bDoAgain()  {
        Prt.prtln("");
        String sAnswer;
        while ( true )   {
            Prt.prt("Look up another? (Y or N) ");
            sAnswer = sc.nextLine();
            if ( sAnswer.equalsIgnoreCase("Y") )
                return true;
            else if ( sAnswer.equalsIgnoreCase("N") )
                return false;
        }
    }
}

