package jdbc;

import java.sql.*;
import java.io.*;

public class PessimisticLockerA  {
	static Connection conn;
	static Statement stmt;
	static Statement stmtA;
	static PreparedStatement pstmt;
	static ResultSet rsetA;

	static String sqlCreate = "create table reservation (roomId varchar(5), res_date date, res_flag boolean, res_name varchar(30));";
	static String sqlInsert = "insert into reservation (roomId, res_date, res_flag, res_name) values (?, ?, ?, ?)";
	static String sqlUpdate = "update reservation set res_flag=?, res_name=? where roomId=? and res_date=?";
	static String sqlSelect = "select roomId, res_date, res_flag, res_name from reservation where res_flag=0 for update;"; // note: for update

	static String roomName;
	static java.sql.Date roomDate;

	public static void main(String[] args)  {
		try  {
			String url = "jdbc:mysql://localhost/testdb";
			String username = "nat";
			String password = "";
			conn = JDBCManagerV3.getConnection(url, username, password, false);  // committing controlled here
			utils.prtln("conn autocommit is " + conn.getAutoCommit());
			setup();
			userAQuery();
			utils.prtln("PessimisticLockerA sleeping for 15 seconds, run PessimisticLockerB");

			try { Thread.sleep(15000); } catch (Exception e) {}
			utils.prtln("PessimisticLockerA is awake");
			userAUpdate();
		} catch (Exception e)  {
			e.printStackTrace();
		} finally  {
			JDBCManagerV3.close(conn);
		}
	}

	static void setup() {
		utils.prtln("Creating reservation table ...");
		try  {
			stmt = conn.createStatement();
			stmt.addBatch(sqlCreate);
			stmt.executeBatch();
			utils.prtln("Inserting table row ...");
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, "pike");
			pstmt.setString(2, "2009-09-30");
			pstmt.setBoolean(3, false);
			pstmt.setNull(4, java.sql.Types.VARCHAR);
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e)  {
			e.printStackTrace();
			JDBCManagerV3.rollback(conn);
		} finally {
			JDBCManagerV3.close(pstmt);
			JDBCManagerV3.close(stmt);
		}
	}

	static void userAQuery() throws SQLException  {
		utils.prtln("User A is querying for rooms");
		stmtA = conn.createStatement();
		rsetA = stmtA.executeQuery(sqlSelect);
		if (rsetA.next())  {
			utils.prtln("Query returned one row");
			roomName = rsetA.getString(1);
			roomDate = rsetA.getDate(2);
			utils.prtln("roomName = " + roomName + ", roomDate = " + roomDate);
		} else {
			utils.prtln("Query returned zero rows");
		}
		// neither the statement nor resultset above are closed here - we need them for the userUpdate() method
	}

	static void userAUpdate() {
		try {
			if (roomName != null && roomDate != null)  {
				utils.prtln("User A is attempting to reserve room");
				pstmt = conn.prepareStatement(sqlUpdate);
				pstmt.setBoolean(1, true);
				pstmt.setString(2, "User A");
				pstmt.setString(3, roomName);
				pstmt.setDate(4, roomDate);
				int result = pstmt.executeUpdate();
				if (result == 0)  {
					utils.prtln("Reservation did NOT succeed, user will have to try another room or date");
				} else {
					utils.prtln("Calling commit for User A");
					conn.commit();
				}
			} else {
				utils.prtln("User A is NOT attempting to reserve room: roomName = " + roomName + ", roomDate = " + roomDate);
			}
		} catch (SQLException e)  {
			e.printStackTrace();
			e.printStackTrace(DriverManager.getLogWriter());
			utils.prtln(e.getErrorCode());
			utils.prtln(e.getMessage());
		} finally {
			JDBCManagerV3.close(rsetA);
			JDBCManagerV3.close(pstmt);
			JDBCManagerV3.close(conn);
		}
	}
}

