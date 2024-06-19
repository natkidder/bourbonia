package Ch07;

import java.sql.*;

public class PessimisticLockerA {
  static Connection conn;
  static Statement stmt;
 

  static Statement stmtA;
  static PreparedStatement pstmt;
  static ResultSet rsetA;

  static String sqlCreate = "create table RESERVE " +
    "(ROOMID varchar(5), RES_DATE date, RES_FLAG boolean, " +
    "RES_NAME varchar(30))";
  static String sqlInsert = "insert into RESERVE values " +
    "(?, ?, ?, ?)";
  static String sqlUpdate = "update RESERVE set RES_FLAG=?, " +
    "RES_NAME=? WHERE ROOMID=? AND RES_DATE=?";
  static String sqlSelect = "select ROOMID, RES_DATE, " +
    "RES_FLAG, RES_NAME from RESERVE WHERE RES_FLAG=false FOR UPDATE";

  static String roomName;
  static java.sql.Date roomDate;

  public static void main(String[] args) {
    try {
      String url = "jdbc:pointbase:server://localhost/pointbaseDB";
      String username = "PBPUBLIC";
      String password = "PBPUBLIC";
      conn = JDBCManager.getConnection(url, username, password, false);
      System.out.println("conn autocommit is " + conn.getAutoCommit());
      setup();
      userAQuery();
      System.out.println("Sleeping for 15 seconds, " +
                         "run PessimisticLockerB");
      try {Thread.sleep(15000);} catch (Exception e) {} 
        System.out.println("PessimisticLockerA is awake");
        userAUpdate();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        JDBCManager.close(conn);
    }
  }

  static void setup() throws SQLException {
    System.out.println("Creating RESERVE table");
    try {
      stmt = conn.createStatement();
      stmt.addBatch(sqlCreate);
      stmt.executeBatch();
      System.out.println("Inserting row of data");
      pstmt = conn.prepareStatement(sqlInsert);
      pstmt.setString(1, "PIKE");
      pstmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
      pstmt.setBoolean(3,false);
      pstmt.setNull(4, java.sql.Types.VARCHAR);
      pstmt.executeUpdate();
      conn.commit();
    } finally {
      JDBCManager.close(pstmt);
 

      JDBCManager.close(stmt);
    }
  }

  static void userAQuery() throws SQLException {
    System.out.println("User A is querying for rooms");
    stmtA = conn.createStatement();
    rsetA = stmtA.executeQuery(sqlSelect);
    if (rsetA.next()) {
      System.out.println("Query returned one row");
      roomName = rsetA.getString(1);
      roomDate = rsetA.getDate(2);
    }
    // Neither the statement nor resultset are closed here
    // We need them open for the userAUpdate() method
  }

  static void userAUpdate() throws SQLException {
    try {
      if (roomName != null && roomDate != null) {
        System.out.println("User A is attempting to reserve room");
        pstmt = conn.prepareStatement(sqlUpdate);
        pstmt.setBoolean(1, true);
        pstmt.setString(2, "User A");
        pstmt.setString(3,roomName);
        pstmt.setDate(4, roomDate);
        int result = pstmt.executeUpdate();
        if (result == 0) {
          System.out.println("Reservation did NOT succeed!");
          System.out.println("The user will have to try " +
                             "another room, or another date");
        } else {
          System.out.println("Calling commit for user A");
          conn.commit();
        }
      }
    } catch (SQLException e) {
      e.printStackTrace(DriverManager.getLogWriter());
      System.out.println(e.getErrorCode());
      System.out.println(e.getMessage());
    } finally {
      JDBCManager.close(pstmt);
      JDBCManager.close(rsetA);
      JDBCManager.close(stmtA);
    }
  }
}
