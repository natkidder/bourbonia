package Ch06;

import java.sql.*;

public class JDBCClient {
  public static void main(String[] args) {
    Connection conn = null;
    try {
      String url = "jdbc:pointbase:server://localhost/pointbaseDB,new";
      String username = "PBPUBLIC";
      String password = "PBPUBLIC";
      conn = DriverLoader.getConnection(url, username, password);
      DatabaseMetaData dbmd = conn.getMetaData();

      System.out.println("db name is " + dbmd.getDatabaseProductName());
      System.out.println("db version is " + dbmd.getDatabaseProductVersion());
      System.out.println("db driver name is " + dbmd.getDriverName());
      System.out.println("db driver version is " + dbmd.getDriverVersion());
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DriverLoader.close(conn);
    }
  }
}
