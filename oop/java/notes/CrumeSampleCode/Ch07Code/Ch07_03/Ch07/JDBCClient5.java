package Ch07;

import java.sql.*;

public class JDBCClient5 {
  static Connection conn = null;
  static PreparedStatement pstmt = null;
  static ResultSet rset = null;

  static String sqlInsert =
    "insert into COUNTRIES "
      + "(COUNTRY, COUNTRY_ISO_CODE, REGION) "
      + "values (?, ?, ?)";

  static String sqlQuery = "select * from COUNTRIES";

  public static void main(String[] args) {
    try {
      String url = "jdbc:pointbase:server://localhost/pointbaseDB";
      String username = "PBPUBLIC";
      String password = "PBPUBLIC";
      conn = JDBCManager.getConnection(url, username, password, false);
      pstmt = conn.prepareStatement(sqlInsert);

      // Transaction begins here
      cleanupTable();
      doEUBatch();
      doNABatch();
      System.out.println(
        "\nChecking the table before " + "commit or rollback:");
      doQuery();

      // Pretend we need to rollback
      JDBCManager.rollback(conn);
      System.out.println("\nChecking the table after rollback:");
      doQuery();
      JDBCManager.close(pstmt);

      pstmt = conn.prepareStatement(sqlInsert);
      doEUBatch();
      doNABatch();
      conn.commit();
      System.out.println("\nChecking the table after commit:");
      doQuery();
    } catch (SQLException e) {

      // An exception means something failed, so do rollback
      JDBCManager.rollback(conn);
      e.printStackTrace();
    } finally {
      JDBCManager.close(rset);
      JDBCManager.close(pstmt);
      JDBCManager.close(conn);
    }
  }

  public static void cleanupTable() {
    // If there is data in the COUNTRIES table from previous examples
    // then delete this old data
    Statement stmt = null;

    try {
      stmt = conn.createStatement();
      stmt.executeUpdate("delete from COUNTRIES");
      conn.commit();
      System.out.println("Database has been cleaned");
    } catch (Exception e) {
      JDBCManager.rollback(conn);
    } finally {
      JDBCManager.close(stmt);
    }
  }

  public static void doEUBatch() throws SQLException {
    pstmt.setString(1, "Kyrgyzstan");
    pstmt.setString(2, "KG");
    pstmt.setString(3, "Asia");
    pstmt.addBatch();

    pstmt.setString(1, "Great Britain");
    pstmt.setString(2, "GB");
    pstmt.setString(3, "Europe");
    pstmt.addBatch();

    pstmt.setString(1, "France");
    pstmt.setString(2, "FR");
    pstmt.addBatch();

    pstmt.executeBatch();
  }

  public static void doNABatch() throws SQLException {
    pstmt.setString(1, "United States");
    pstmt.setString(2, "US");
    pstmt.setString(3, "North America");
    pstmt.addBatch();

    pstmt.setString(1, "Canada");
    pstmt.setString(2, "CA");
    pstmt.addBatch();

    pstmt.executeBatch();
  }

  public static void doQuery() throws SQLException {
    Statement stmt = null;
    try {
      stmt = conn.createStatement();
      rset = stmt.executeQuery(sqlQuery);
      int rownum = 1;
      if (rset.next()) {
        do {
          System.out.print("row " + rownum++ +" is ");
          System.out.print(rset.getString(1) + ", ");
          System.out.print(rset.getString(2) + ", ");
          System.out.println(rset.getString(3));

        } while (rset.next());
      } else {
        System.out.println("No results in table");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCManager.close(rset);
      JDBCManager.close(stmt);
    }
  }
}