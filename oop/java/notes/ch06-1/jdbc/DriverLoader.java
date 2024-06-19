package jdbc;

import java.sql.*;
import java.util.*;

public class DriverLoader  {
	private DriverLoader()  {}

	public static Connection getConnection(String url)  throws Exception  {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		DriverManager.setLoginTimeout(10);
		return DriverManager.getConnection(url);
	}

	public static Connection getConnection(String url, String user, String password) throws Exception  {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		return DriverManager.getConnection(url, user, password);
	}

	public static Connection getConnection(String url, Properties props) throws Exception  {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		return DriverManager.getConnection(url, props);
	}

	public static void close(Connection conn)  {
		try  {
			conn.close();
		} catch (SQLException se)  {
			se.printStackTrace();
		}
	}
}
