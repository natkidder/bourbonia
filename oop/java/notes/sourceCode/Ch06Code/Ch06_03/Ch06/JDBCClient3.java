package Ch06;

import java.sql.*;

public class JDBCClient3 {
  static Connection conn = null;
  static Statement stmt = null;
  static ResultSet rset = null;

  static String sqlInsert00 =
    "insert into COUNTRIES "
      + "(COUNTRY, COUNTRY_ISO_CODE, REGION) "
      + "values ('Kyrgyzstan', 'KG', 'Asia')";
  static String sqlInsert01 =
    "insert into COUNTRIES "
      + "(COUNTRY, COUNTRY_ISO_CODE, REGION) "
      + "values ('Great Britain', 'GB', 'Europe')";
  static String sqlInsert02 =
    "insert into COUNTRIES "
      + "(COUNTRY, COUNTRY_ISO_CODE, REGION) "
      + "values ('United States', 'US', 'North America')";
  static String sqlInsert03 =
    "insert into COUNTRIES "
      + "(COUNTRY, COUNTRY_ISO_CODE, REGION) "
      + "values ('Canada', 'CA', 'North America')";
  static String sqlInsert04 =
    "insert into COUNTRIES "
      + "(COUNTRY, COUNTRY_ISO_CODE, REGION) "
      + "values ('France', 'FR', 'Europe')";
  static String sqlQuery = "select * from COUNTRIES";

  public static void main(String[] args) {
    try {
      String url = "jdbc:pointbase:server://localhost/pointbaseDB";
      String username = "PBPUBLIC";
      String password = "PBPUBLIC";
      conn = JDBCManagerV2.getConnection(url, username, password);
      stmt =
        conn.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY);

      doBatch();
      doQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCManagerV2.close(rset);
      JDBCManagerV2.close(stmt);
      JDBCManagerV2.close(conn);
    }
  }

  public static void doBatch() throws SQLException {
    stmt.addBatch(sqlInsert00);
    stmt.addBatch(sqlInsert01);
    stmt.addBatch(sqlInsert02);
    stmt.addBatch(sqlInsert03);
    stmt.addBatch(sqlInsert04);
    int[] results = stmt.executeBatch();
  }

  public static void doQuery() throws SQLException {
    rset = stmt.executeQuery(sqlQuery);
    System.out.println("rset.next()=" + rset.next());
    System.out.println("Should be on first row: isFirst()=" + rset.isFirst());
    // Now move forward two rows
    rset.next(); // Row 2
    rset.next(); // Row 3
    System.out.println("row num should be 3, getRow()=" + rset.getRow());
    rset.next(); // Row 4
    System.out.print("Row 4 - ");
    System.out.print(rset.getString(1) + " - ");
    System.out.print(rset.getString(2) + " - ");
    System.out.println(rset.getString(3));
    rset.next(); //row 5
    System.out.println("Should be on last row: isLast()=" + rset.isLast());
    rset.previous();
    System.out.println("Should not be on last row: isLast()=" + rset.isLast());
    rset.beforeFirst();
    System.out.println(
      "Should be before first row: isBeforeFirst()=" + rset.isBeforeFirst());
  }
}
