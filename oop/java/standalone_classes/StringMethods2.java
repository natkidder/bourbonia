// LB 363, book 4, chapter 1
import utilities.*;
import java.util.*;

public class StringMethods2   {

	static PrtObj p = new PrtObj();

	public static void main(String args[]) {
		int i = 0; int j = 0;
		Scanner scKB = new Scanner(System.in);
		try  {
			p.prt("Enter a String (s1): ");
			String s1 = scKB.nextLine();
			p.prt("Enter a String (s2): ");
			String s2 = scKB.nextLine();
			p.prt("enter a String (s3): ");
			String s3 = scKB.nextLine();
			p.prt("Enter an integer (i): ");
			i = scKB.nextInt();
			p.prt("Enter an integer (j): ");
			j = scKB.nextInt();
			String read;
			int k = 0;

			p.prtln( s1 + ".lastIndexOf(" + s2 + ") = " + s1.lastIndexOf(s2) );
			p.prtln( s1 + ".length() = " + s1.length() );
			p.prtln( s1 + ".replace(" + s2 + ", " + s3 + ") = " + s1.replace(s2, s3) );
			p.prtln( s1 + ".replaceAll(" + s2+ ", " + s3 + ") = " + s1.replaceAll(s2, s3) );
			p.prtln( s1 + ".replaceFirst(" + s2 + ", " + s3 + ") = " + s1.replaceFirst(s2, s3) );
			String sArray[] = s1.split(s2);
			p.prt( "Enter a character and tap Return: " ); read = scKB.next();
			for ( String s4 : sArray )  {
			    p.prtln(s1 + ".split(" + s2 + ")[" + k + "] = " + s4 );
				k++;
			}
			p.prtln( s1 + ".startsWith(" + s2 + ") = " + s1.startsWith(s2) );
			p.prtln( s1 + ".startsWith(" + s2 + ", " + i + ") = " + s1.startsWith(s1, i) );
			p.prtln( s1 + ".substring(" + i + ") = " + s1.substring(i) );
			p.prtln( s1 + ".substring(" + i + ", " + j + ") = " + s1.substring(i, j) );
			k = 0;
			p.prt( "Enter a character and tap Return: "); read = scKB.next();
			for (char c : s1.toCharArray() )  {
				p.prtln(s1 + ".toCharArray()[" + k + "] = " + c);
				k++;
			}
			p.prtln( s1 + ".toLowerCase() = " + s1.toLowerCase() );
			p.prtln( s1 + ".toString() = " + s1.toString() );
			p.prtln( s1 + ".toUpperCase() = " + s1.toUpperCase() );
			p.prtln( s1 + ".trim() = " + s1.trim() );
			p.prtln( s1 + ".valueOf(" + i + ") " + s1.valueOf(i) );
		}
		catch (InputMismatchException ime)  {
			p.prtln( ime.toString() + ": wrong data type entered");
		}
		catch (StringIndexOutOfBoundsException sioobe)  {
			p.prtln( sioobe.toString() + ": One of the indexes you entered is out of bounds");
//			i = scKB.nextInt();
//			j = scKB.nextInt();
		}
	}
}
