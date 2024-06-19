package Ch06;

import java.sql.*;
import java.util.Properties;

public class JDBCManagerV2 {
  private JDBCManagerV2() {
  }

  public static Connection getConnection(String url) throws SQLException {
    DriverManager.setLoginTimeout(10);
    return DriverManager.getConnection(url);
  }

  public static Connection getConnection(
    String url,
    String user,
    String password)
    throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }

  public static Connection getConnection(String url, Properties props)
    throws SQLException {
    return DriverManager.getConnection(url, props);
  }

  public static void close(Connection conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void close(Statement stmt) {
    if (stmt != null) {
      try {
        stmt.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void close(ResultSet rset) {
    if (rset != null) {
      try {
        rset.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
