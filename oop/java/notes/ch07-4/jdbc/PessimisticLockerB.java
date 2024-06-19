package jdbc;

import java.sql.*;
import java.io.*;

public class PessimisticLockerB  {
	static Connection conn;
	static Statement stmt;
	static Statement stmtB;
	static PreparedStatement pstmt;
	static ResultSet rsetB;

	static String sqlUpdate = "update reservation set res_flag=?, res_name='?' where roomId='?' and res_date='?';";
	//static String sqlUpdate = "update reservation set res_flag=?, res_name=?;";
	static String sqlSelect = "select roomId, res_date, res_flag, res_name from reservation where res_flag=false for update;"; // note the for update

	static String roomName;
	static java.sql.Date roomDate;

	public static void main(String[] args)  {
		try  {
			String url = "jdbc:mysql://localhost:3306/testdb";
			String username = "nat";
			String password = "";
			conn = JDBCManagerV3.getConnection(url, username, password, false);
			utils.prtln("conn autocommit is " + conn.getAutoCommit());
			userBQueryAndUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCManagerV3.close(conn);
		}
	}

	static void userBQueryAndUpdate() {
		utils.prtln("User B is querying for rooms");
		try {
			stmtB = conn.createStatement();
			rsetB = stmtB.executeQuery(sqlSelect);
			if (rsetB.next())  {
				utils.prtln("User B is reserving the room");
				pstmt = conn.prepareStatement(sqlUpdate);
				pstmt.setBoolean(1, true);
				pstmt.setString(2, "User B");
				pstmt.setString(3, rsetB.getString(1));
				pstmt.setDate(4, rsetB.getDate(2));
				pstmt.executeUpdate();
				utils.prtln("Call commit for user B");
				conn.commit();
			} else {
				utils.prtln("User B found no available rooms");
			}
		} catch (SQLException e)  {
			e.printStackTrace();
			utils.prtln(e.getErrorCode());
			utils.prtln(e.getMessage());
		} finally {
			JDBCManagerV3.close(pstmt);
			JDBCManagerV3.close(rsetB);
			JDBCManagerV3.close(stmtB);
		}
	}
}
