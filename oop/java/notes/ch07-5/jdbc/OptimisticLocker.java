package jdbc;

import java.sql.*;
import java.io.*;

public class OptimisticLocker  {
	static Connection conn;
	static Statement stmt;
	static PreparedStatement pstmt;
	static ResultSet rset;

	static String sqlCreate = "create table if not exists reservation (roomId varchar(5), res_date date, res_flag boolean, res_name varchar(30));";
	static String sqlTrunc = "truncate table reservation;";
	static String sqlInsert = "insert into reservation (roomId, res_date, res_flag, res_name) values (?, ?, ?, ?);";
	static String sqlUpdate = "update reservation set res_flag = ?, res_name = ? where roomId = ? and res_date = ? and res_flag = ?;";
	static String sqlSelect = "select roomId, res_date, res_flag, res_name from reservation where res_flag = 0;";

	static String roomName;
	static java.sql.Date roomDate;
	static boolean reservationStatus;

	public static void main(String[] args) {
		try  {
			String url = "jdbc:mysql://localhost:3306/testdb";
			String user = "nat";
			String pwd = "";
			conn = JDBCManagerV3.getConnection(url, user, pwd, true);
			stmt = conn.createStatement();
			setup();
			userAQuery();
			userBQueryAndUpdate();
			userAUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCManagerV3.close(rset);
			JDBCManagerV3.close(pstmt);
			JDBCManagerV3.close(stmt);
			JDBCManagerV3.close(conn);
		}
	}

	private static void setup() throws SQLException  {
		utils.prtln("creating/truncating reservation table");
		stmt.addBatch(sqlCreate);
		stmt.addBatch(sqlTrunc);
		stmt.executeBatch();
		utils.prtln("inserting row of data");
		pstmt = conn.prepareStatement(sqlInsert);
		pstmt.setString(1, "Pike");
		pstmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
		pstmt.setBoolean(3, false);
		pstmt.setString(4, "");
		pstmt.executeUpdate();
		JDBCManagerV3.close(pstmt);
	}

	private static void userAQuery() throws SQLException  {
		try {
			utils.prtln("User A is querying for rooms");
			rset = stmt.executeQuery(sqlSelect);
			if (rset.next())  {
				roomName = rset.getString(1);
				roomDate = rset.getDate(2);
				reservationStatus = rset.getBoolean(3);
			} else {
				utils.prtln("No rooms returned for User A");
			}
		} finally  {
			JDBCManagerV3.close(rset);
		}
	}

	private static void userBQueryAndUpdate() throws SQLException {
		try {
			utils.prtln("User B is querying for rooms");
			rset = stmt.executeQuery(sqlSelect);
			if (rset.next())  {
				utils.prtln("User B is reserving a room");
				pstmt = conn.prepareStatement(sqlUpdate);
				pstmt.setBoolean(1, true);
				pstmt.setString(2, "UserB");
				pstmt.setString(3, rset.getString(1));
				pstmt.setDate(4, rset.getDate(2));
				pstmt.setBoolean(5, rset.getBoolean(3));
				pstmt.executeUpdate();
			} else {
				utils.prtln("No rows returned for User B");
			}
		} finally {
			JDBCManagerV3.close(rset);
			JDBCManagerV3.close(pstmt);
		}
	}

	private static void userAUpdate() throws SQLException  {
		try {
			utils.prtln("User A is attempting to reserve the room");
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setBoolean(1, true);
			pstmt.setString(2, "UserA");
			pstmt.setString(3, roomName);
			pstmt.setDate(4, roomDate);
			pstmt.setBoolean(5, reservationStatus);
			int count = pstmt.executeUpdate();
			if (count == 0)  {
				utils.prtln("User A could not reserve the room.  She or he will need to use another date.");
			}
		} finally {
			JDBCManagerV3.close(pstmt);
		}
	}
}

		
			

