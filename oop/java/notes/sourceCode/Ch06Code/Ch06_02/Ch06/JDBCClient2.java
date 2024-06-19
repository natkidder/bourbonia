package Ch06;

import java.sql.*;

public class JDBCClient2 {
  static Connection conn = null;
  static Statement stmt = null;

  static String sqlCreateTable =
    "create table COUNTRIES "
      + "(COUNTRY VARCHAR(26), COUNTRY_ISO_CODE VARCHAR(2) NOT NULL, "
      + "REGION VARCHAR(26))";
  static String sqlInsert =
    "insert into COUNTRIES "
      + "(COUNTRY, COUNTRY_ISO_CODE, REGION) "
      + "values ('Kyrgyzstan', 'KZ', 'Asia')";
  static String sqlUpdate =
    "update COUNTRIES set COUNTRY_ISO_CODE='KG'"
      + " where COUNTRY='Kyrgyzstan'";
  static String sqlDelete =
    "delete from COUNTRIES " + "where COUNTRY='Kyrgyzstan'";
  static String sqlDropTable = "drop table COUNTRIES";

  public static void main(String[] args) {
    try {
      String url = "jdbc:pointbase:server://localhost/pointbaseDB,new";
      String username = "PBPUBLIC";
      String password = "PBPUBLIC";
      conn = JDBCManagerV1.getConnection(url, username, password);
      stmt = conn.createStatement();

      createTable();
      doInsert();
      doUpdate();
      doDelete();
      dropTable();
      doBatch();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCManagerV1.close(stmt);
      JDBCManagerV1.close(conn);
    }
  }

  public static void createTable() throws SQLException {
    int result = stmt.executeUpdate(sqlCreateTable);
    System.out.println("Create affected " + result + " rows (expected 0)");
  }

  public static void doInsert() throws SQLException {
    int result = stmt.executeUpdate(sqlInsert);
    System.out.println("Inserted " + result + " rows (expected 1)");
  }

  public static void doUpdate() throws SQLException {
    int result = stmt.executeUpdate(sqlUpdate);
    System.out.println("Updated " + result + " rows (expected 1)");
  }

  public static void doDelete() throws SQLException {
    int result = stmt.executeUpdate(sqlDelete);
    System.out.println("Deleted " + result + " rows (expected 1)");
  }

  public static void dropTable() throws SQLException {
    int result = stmt.executeUpdate(sqlDropTable);
    System.out.println("Drop affected " + result + " rows (expected 0)");
  }

  public static void doBatch() throws SQLException {
    stmt.addBatch(sqlCreateTable);
    stmt.addBatch(sqlInsert);
    stmt.addBatch(sqlUpdate);
    stmt.addBatch(sqlDelete);

    int[] results = stmt.executeBatch();
    for (int i = 0; i < results.length; i++) {
      System.out.println("result[" + i + "]=" + results[i]);
    }
  }
}
