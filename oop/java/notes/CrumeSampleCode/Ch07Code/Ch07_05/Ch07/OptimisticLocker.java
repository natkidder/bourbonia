package Ch07;

import java.sql.*;

public class OptimisticLocker {
  static Connection conn;
  static Statement stmt;
  static PreparedStatement pstmt;
  static ResultSet rset;

  static String sqlCreate = "create table RESERVE " +
    "(ROOMID varchar(5), RES_DATE date, RES_FLAG boolean, " +
 

    "RES_NAME varchar(30))";
  static String sqlInsert = "insert into RESERVE values " +
    "(?, ?, ?, ?)";
  static String sqlUpdate = "update RESERVE set RES_FLAG=?, " +
    "RES_NAME=? WHERE ROOMID=? AND RES_DATE=? AND RES_FLAG=?";
  static String sqlSelect = "select ROOMID, RES_DATE, " +
    "RES_FLAG, RES_NAME from RESERVE WHERE RES_FLAG=FALSE";

  static String roomName;
  static java.sql.Date roomDate;
  static boolean reserveStatus;

  public static void main(String[] args) {
    try {
      String url = "jdbc:pointbase:server://localhost/pointbaseDB";
      String username = "PBPUBLIC";
      String password = "PBPUBLIC";
      conn = JDBCManager.getConnection(url, username, password);
      stmt = conn.createStatement();
      setup();
      userAQuery();
      userBQueryAndUpdate();
      userAUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCManager.close(rset);
      JDBCManager.close(pstmt);
      JDBCManager.close(stmt);
      JDBCManager.close(conn);
    } 
  }

  static void setup() throws SQLException {
    System.out.println("Creating RESERVE table");
    stmt.addBatch(sqlCreate);
    stmt.executeBatch();
    System.out.println("Inserting row of data");
    pstmt = conn.prepareStatement(sqlInsert);
    pstmt.setString(1, "PIKE");
    pstmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
    pstmt.setBoolean(3,false);
    pstmt.setNull(4, java.sql.Types.VARCHAR);
    pstmt.executeUpdate();
    JDBCManager.close(pstmt);
  }

  static void userAQuery() throws SQLException {
    System.out.println("User A is querying for roooms");
    rset = stmt.executeQuery(sqlSelect);
    rset.next();
    roomName = rset.getString(1);
    roomDate = rset.getDate(2);
    reserveStatus = rset.getBoolean(3);
 

    JDBCManager.close(rset);
  }

  static void userBQueryAndUpdate() throws SQLException {
    System.out.println("User B is querying for rooms");
    rset = stmt.executeQuery(sqlSelect);
    rset.next();
    System.out.println("User B is reserving room");
    pstmt = conn.prepareStatement(sqlUpdate);
    pstmt.setBoolean(1, true);
    pstmt.setString(2, "Jennifer");
    pstmt.setString(3,rset.getString(1));
    pstmt.setDate(4, rset.getDate(2));
    pstmt.setBoolean(5, rset.getBoolean(3));
    pstmt.executeUpdate();
    JDBCManager.close(rset);
    JDBCManager.close(pstmt);
  }

  static void userAUpdate() throws SQLException {
    System.out.println("User A is attempting to reserve room");
    pstmt = conn.prepareStatement(sqlUpdate);
    pstmt.setBoolean(1, true);
    pstmt.setString(2, "Beth");
    pstmt.setString(3,roomName);
    pstmt.setDate(4, roomDate);
    pstmt.setBoolean(5, reserveStatus);
    int result = pstmt.executeUpdate();
    if (result == 0) {
      System.out.println("Reservation for User A did NOT succeed!");
      System.out.println("User A will have to try " +
                         "another room, or another date");
    }
    JDBCManager.close(pstmt);
  }
}
