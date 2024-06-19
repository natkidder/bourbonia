// LB 363, book 4, chapter 1
// originated at work
import java.util.regex.*;
import java.util.Scanner;
import utilities.*;

public final class StringFuncts  {
    static PrtObj p = new PrtObj();
    static Scanner scKeyboard = new Scanner(System.in);

    public static void main(String args[])  {
        String sArg, sArg2, sArg3, sEnt;
        int iArg;

        p.prt("Enter a string: ");
        sArg = scKeyboard.nextLine();
        p.prt("\nEnter another string: ");
        sArg2 = scKeyboard.nextLine();
        p.prt("\nEnter yet another string: ");
        String sArg21 = scKeyboard.nextLine();
        p.prt("\nEnter a single letter: ");
        sArg3 = scKeyboard.nextLine().substring(0, 1);
        p.prt("\nEnter another single letter: ");
        String sArg31 = scKeyboard.nextLine().substring(0, 1);
        p.prt("\nEnter an integer: ");
        iArg = scKeyboard.nextInt();
        p.prt("\nEnter another integer: ");
        int iArg2 = scKeyboard.nextInt();

        try {

            p.prtln(sArg + ".length() = " + sArg.length() );
            p.prtln(sArg + ".charAt(" + iArg + ") = " + sArg.charAt(iArg));
            p.prtln(sArg + ".compareTo(" + sArg2 + ") = " + sArg.compareTo(sArg2));
            p.prtln(sArg + ".compareToIgnoreCase(" + sArg2 + ") = " + sArg.compareToIgnoreCase(sArg2));
            p.prtln(sArg + ".contains(" + sArg2 + ") = " + sArg.contains(sArg2));
            p.prtln(sArg + ".endsWith(" + sArg2 + ") = " + sArg.endsWith(sArg2));

            p.prt("1 char, then <Enter>: "); sEnt = scKeyboard.next();
            p.prtln("");

            p.prtln(sArg + ".equals(" + sArg2 + ") = " + sArg.equals(sArg2));
            p.prtln(sArg + ".equalsIgnoreCase(" + sArg2 + ") = " + sArg.equalsIgnoreCase(sArg2));
            p.prtln(sArg + ".indexOf(" + sArg2 + ") = " + sArg.indexOf(sArg2));
            p.prtln(sArg + ".indexOf(" + sArg3 + ") = " + sArg.indexOf(sArg3));
            p.prtln(sArg + ".indexOf(" + sArg2 + ", " + iArg + ") = " + sArg.indexOf(sArg2, iArg));

            p.prt("1 char, then <Enter>: "); sEnt = scKeyboard.next();
p.prtln("");

            p.prtln(sArg + ".lastIndexOf(" + sArg2 + ") = " + sArg.lastIndexOf(sArg2));
            p.prtln(sArg + ".lastIndexOf(" + sArg3 + ") = " + sArg.lastIndexOf(sArg3));
            p.prtln(sArg + ".lastIndexOf(" + sArg2 + ", " + iArg + ") = " + sArg.lastIndexOf(sArg2, iArg));
            p.prtln(sArg + ".length() = " + sArg.length() );
            p.prtln(sArg + ".replace(" + sArg3 + ", " + sArg31 + ") = " + sArg.replace(sArg3, sArg31) );

            p.prt("1 char, then <Enter>: "); sEnt = scKeyboard.next();
p.prtln("");

            p.prtln(sArg + ".replaceAll(" + sArg3 + ", " + sArg31 + ") = " + sArg.replaceAll(sArg3, sArg31) );
            p.prtln(sArg + ".replaceAll(" + sArg2 + ", " + sArg21 + ") = " + sArg.replaceAll(sArg2, sArg21) );
            p.prtln(sArg + ".replaceFirst(" + sArg3 + ", " + sArg31 + ") = " + sArg.replaceFirst(sArg3, sArg31) );
            p.prtln(sArg + ".replaceFirst(" + sArg2 + ", " + sArg21 + ") = " + sArg.replaceFirst(sArg2, sArg21) );

            p.prt("1 char, then <Enter>: "); sEnt = scKeyboard.next();
p.prtln("");

            p.prtln(sArg + ".split(" + sArg3 + "):");
            String sArray[] = sArg.split(sArg3);
            int i = 0;
            for (String sElem : sArray)  {
                p.prtln("sArray[" + i + "] = " + sElem);
                i++;
            }

            p.prt("1 char, then <Enter>: "); sEnt = scKeyboard.next();
p.prtln("");

            p.prtln(sArg + ".split(" + sArg2 + "):");
            sArray = sArg.split(sArg2);
            i = 0;
            for (String sElem : sArray)  {
                p.prtln("sArray[" + i + "] = " + sElem);
               i++;
            }

            p.prt("1 char, then <Enter>: "); sEnt = scKeyboard.next();
p.prtln("");

            p.prtln(sArg + ".startsWith(" + sArg2 + ") = " + sArg.startsWith(sArg2) );
            p.prtln(sArg + ".startsWith(" + sArg21 + ", " + iArg + ") = " + sArg.startsWith(sArg21, iArg) );
            p.prtln(sArg + ".substring(" + iArg + ") = " + sArg.substring(iArg) );
            p.prtln(sArg + ".substring(" + iArg + ", " + iArg2 + ") = " + sArg.substring(iArg, iArg2) );

            p.prt("1 char, then <Enter>: "); sEnt = scKeyboard.next();
p.prtln("");

            p.prtln(sArg + ".toCharArray()");
            char cArray[] = sArg.toCharArray();
            i = 0;
            for (char cElem : cArray)  {
                p.prtln("cArray[" + i + "] = " + cElem);
                i++;
            }

            p.prt("1 char, then <Enter>: "); sEnt = scKeyboard.next();
p.prtln("");

            p.prtln(sArg + ".toLowerCase() = " + sArg.toLowerCase() );
            p.prtln(sArg + ".toString() = " + sArg.toString() + " (all Java base types have a toString method)");
            p.prtln(sArg + ".toUpperCase() = " + sArg.toUpperCase() );
            p.prtln(sArg + ".trim() = '" + sArg.trim() + "'" );
            p.prtln(sArg + ".valueOf(" + iArg + ") = " + sArg.valueOf(iArg) );

        }
        catch (Exception ex)   {
            ex.printStackTrace();
        }
    }
}
