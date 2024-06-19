package jdbc;

import java.sql.*;

public class JDBCClient  {
	public static void main(String[] args)  {
		Connection conn = null;
		try  { 
			String url;
			if (args.length < 1)  {
				url = "jdbc:mysql://localhost/testdb";
			} else {
				url = args[0];
			}
			String username = "nat";
			String password = "";
			conn = DriverManager.getConnection(url, username, password);
			DatabaseMetaData dbmd = conn.getMetaData();

			utilities.prtln("db name is " + dbmd.getDatabaseProductName());
			utilities.prtln("db version is " + dbmd.getDatabaseProductVersion());
			utilities.prtln("db driver name is " + dbmd.getDriverName());
			utilities.prtln("db driver version is " + dbmd.getDriverVersion());
		} catch (SQLException se)  {
			se.printStackTrace();
		} finally {
			DriverLoader.close(conn);
		}
	}
}
