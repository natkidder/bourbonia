package jdbc;

import java.sql.*;
import java.util.*;

public class JDBCManagerV3  {
	private JDBCManagerV3()  {}  //ensures a singleton class

	// returns a connection with autocommit set to true
	public static Connection getConnection(String url) throws Exception {
		return getConnection(url, true);
	}

	// returns a connection with autocommit set by the autocommit parameter
	public static Connection getConnection(String url, boolean autocommit) throws Exception  {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection(url);
		conn.setAutoCommit(autocommit);
		return conn;
	}

	// returns a connection with String arguments autocommit set to true
	public static Connection getConnection(String url, String user, String pwd) throws Exception {
		return getConnection(url, user, pwd, true);
	}

	// returns a connection with url, username, password and autocommit specified
	public static Connection getConnection(String url, String user, String pwd, boolean autocommit) throws Exception  {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection(url, user, pwd);
		conn.setAutoCommit(autocommit);
		return conn;
	}

	// returns a connection with properties and sets autocommit to true
	public static Connection getConnection (String url, Properties props) throws Exception  {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = getConnection(url, props, true);
		return conn;
	}

	// returns a connection with properties and autommits set at runtime
	public static Connection getConnection(String url, Properties props, boolean autocommit) throws Exception  {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection(url, props);
		conn.setAutoCommit(autocommit);
		return conn;
	}

	public static void rollback(Connection conn)   {
		if (conn != null)  {
			try {
				conn.rollback();
			} catch (SQLException e)  {
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection conn)  {
		if (conn != null)  {
			try  {
				conn.close();
			} catch (SQLException e)  {
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement stmt)  {
		if (stmt != null)  {
			try  {
				stmt.close();
			} catch (SQLException e)  {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pstmt)  {
		if (pstmt != null)  {
			try  {
				pstmt.close();
			} catch (SQLException e)  {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rset)  {
		if (rset != null)  {
			try  {
				rset.close();
			} catch (Exception e)  {
				e.printStackTrace();
			}
		}
	}
}
