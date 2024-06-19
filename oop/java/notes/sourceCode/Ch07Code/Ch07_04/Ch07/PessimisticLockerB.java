package Ch07;

import java.sql.*;

public class PessimisticLockerB {
  static Connection conn;
  static Statement stmt;
  static Statement stmtB;
  static PreparedStatement pstmt;
  static ResultSet rsetB;

  static String sqlUpdate =
    "update RESERVE set RES_FLAG=?, "
      + "RES_NAME=? WHERE ROOMID=? AND RES_DATE=?";
  static String sqlSelect =
    "select ROOMID, RES_DATE, "
      + "RES_FLAG, RES_NAME from RESERVE WHERE RES_FLAG=false FOR UPDATE";

  static String roomName;
  static java.sql.Date roomDate;

  public static void main(String[] args) {
    try {
      String url = "jdbc:pointbase:server://localhost/pointbaseDB";
      String username = "PBPUBLIC";
      String password = "PBPUBLIC";
      conn = JDBCManager.getConnection(url, username, password, false);
      System.out.println("conn autocommit is " + conn.getAutoCommit());
      userBQueryAndUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCManager.close(conn);
    }
  }

  static void userBQueryAndUpdate() throws SQLException {
    System.out.println("User B is querying for rooms");
    try {
      stmtB = conn.createStatement();
      rsetB = stmtB.executeQuery(sqlSelect);
      if (rsetB.next()) {
        System.out.println("User B is reserving room");
        pstmt = conn.prepareStatement(sqlUpdate);
        pstmt.setBoolean(1, true);
        pstmt.setString(2, "User B");
        pstmt.setString(3, rsetB.getString(1));
        pstmt.setDate(4, rsetB.getDate(2));
        pstmt.executeUpdate();
        System.out.println("Calling commit for user B");
        conn.commit();
      } else {
        System.out.println("User B found no available rooms");
      }
    } catch (SQLException e) {

      e.printStackTrace();
      System.out.println(e.getErrorCode());
      System.out.println(e.getMessage());
    } finally {
      JDBCManager.close(pstmt);
      JDBCManager.close(rsetB);
      JDBCManager.close(stmtB);
    }
  }
}
