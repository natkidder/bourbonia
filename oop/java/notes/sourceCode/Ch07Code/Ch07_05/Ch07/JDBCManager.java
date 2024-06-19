package Ch07;

import java.sql.*;
import java.util.*;

public class JDBCManager {
  private JDBCManager() {
  }

  //Returns a connection with autocommit true
  public static Connection getConnection(String url) throws SQLException {
    return getConnection(url, true);
  }

  //Returns a connection with autocommit set by the autocommit parameter
  public static Connection getConnection(String url, boolean autocommit)
    throws SQLException {
    Connection connection = DriverManager.getConnection(url);
    connection.setAutoCommit(autocommit);
    return connection;
  }

  //Returns a connection with autocommit true
  public static Connection getConnection(
    String url,
    String user,
    String password)
    throws SQLException {
    return getConnection(url, user, password, true);
  }

  //Returns a connection with autocommit set by the autocommit parameter
  public static Connection getConnection(
    String url,
    String user,
    String password,
    boolean autocommit)
    throws SQLException {
    Connection connection = DriverManager.getConnection(url, user, password);
    connection.setAutoCommit(autocommit);
    return connection;
  }

  //Returns a connection with autocommit true
  public static Connection getConnection(String url, Properties props)
    throws SQLException {
    return getConnection(url, props, true);
  }

  //Returns a connection with autocommit set by the autocommit parameter
  public static Connection getConnection(
    String url,
    Properties props,
    boolean autocommit)
    throws SQLException {
    Connection connection = DriverManager.getConnection(url, props);
    connection.setAutoCommit(autocommit);
    return connection;
  }

  public static void rollback(Connection conn) {
    try {
      conn.rollback();
    } catch (Exception e) {
      e.printStackTrace();
    }
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
