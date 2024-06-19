package Ch06;

import java.sql.*;
import java.util.*;

public class DriverLoader {
  private DriverLoader() {
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
}
