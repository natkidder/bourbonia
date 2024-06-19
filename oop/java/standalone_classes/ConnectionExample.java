/* LB 722, Book 8, Chapter 4
establishes a MySql connection
*/

import java.sql.*;

public class ConnectionExample  {

	private static void prtln( String s ) { System.out.println( s );  }

	public static void main( String[] args )  {
		try  {
			prtln( "main 1" );
			Connection con = getConnection();
			prtln( "main 2" );
			System.out.println( "message " + con.isClosed() );
			prtln( "main 3" );
		}
		catch ( SQLException se )  {
			prtln( se.getMessage() );
		}
	}

	private static Connection getConnection()  {

		Connection con = null;
		try  {
			prtln( "getConnection 1" );
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			prtln( "getConnection 2" );
			String url = "jdbc:mysql://localhost/businesscontacts";
			prtln( "getConnection 3" );
			String user = "nkidder";
			prtln( "getConnection 4" );
			String pw = "wlypb";
			prtln( "getConnection 5" );
			con = DriverManager.getConnection( url, user, pw );
			prtln( "getConnection 6" );
		}
		catch ( ClassNotFoundException cnfe )  {
			prtln( "ClassNotFoundException: " + cnfe.getMessage() );
			System.exit( 1 );
		}
		catch( InstantiationException ie )  {
			prtln( "InstantiationException: " + ie.getMessage() );
			System.exit( 3 );
		}
		catch( IllegalAccessException iae )  {
			prtln( "IllegalAccessException: " + iae.getMessage() );
			System.exit( 3 );
		}

		catch ( SQLException se )  {
			prtln( "SQLException: " + se.getMessage() );
			System.exit( 2 );
		}
		return con;
	}
}
