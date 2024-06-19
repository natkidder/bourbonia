package Ch07;

import java.sql.*;

public class JDBCClient4 {
  static Connection conn = null;
  static Statement stmt;
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
      conn = JDBCManagerV2.getConnection(url, username, password);
      doBatch();
      doQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCManagerV2.close(rset);
      JDBCManagerV2.close(stmt);
      JDBCManagerV2.close(pstmt);
      JDBCManagerV2.close(conn);

    }
  }

  public static void doBatch() throws SQLException {
    pstmt = conn.prepareStatement(sqlInsert);

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

    pstmt.setString(1, "United States");
    pstmt.setString(2, "US");
    pstmt.setString(3, "North America");
    pstmt.addBatch();

    pstmt.setString(1, "Canada");
    pstmt.setString(2, "CA");
    pstmt.addBatch();

    int[] results = pstmt.executeBatch();
    System.out.println("Results of inserts (value should be 1 for each):");
    for (int i = 0; i < results.length; i++) {
      System.out.println("results[" + i + "]=" + results[i]);
    }
  }

  public static void doQuery() throws SQLException {
    stmt = conn.createStatement();
    rset = stmt.executeQuery(sqlQuery);
    rset = stmt.executeQuery(sqlQuery);
    System.out.println("Checking the table:");
    int rownum = 1;
    while (rset.next()) {
      System.out.print("row " + rownum++ +" is ");
      System.out.print(rset.getString(1) + ", ");
      System.out.print(rset.getString(2) + ", ");
      System.out.println(rset.getString(3));
    }
  }
}
