
import java.sql.*;
import java.util.*;

public class JDBCManager {

		private JDBCManager()  {}  //ensures a singleton class

	    public static Connection getConnection(String url)  throws Exception  {
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        DriverManager.setLoginTimeout(10);
	        return DriverManager.getConnection(url);
	    }


	    public static Connection getConnection(String url, String user, String password) throws Exception  {
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection(url, user, password);
	    }


		public static Connection getConnection(String url, Properties props) throws Exception   {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	        return DriverManager.getConnection(url, props);
		}

		public static void close(Connection conn)  {
			if (conn != null)  {
				try  {
					conn.close();
				} catch (Exception e)  {
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

		public static void close(Statement stmt)  {
			if (stmt != null)  {
				try  {
					stmt.close();
				} catch (Exception e)  {
					e.printStackTrace();
				}
			}
		}
}

