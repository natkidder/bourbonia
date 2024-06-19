package jdbc;

import java.sql.*;
import java.io.*;

public class DropTbl  {
	static String url;
	static String user;
	static String pwd;
	static Connection conn = null;
	static Statement stmt = null;
	public static void main(String[] args) {
		try {
			url = "jdbc:mysql://localhost/testdb";
			user = "nat";
			pwd = "";
			conn = JDBCManagerV3.getConnection(url, user, pwd, true);
			stmt = conn.createStatement();
			stmt.executeUpdate("drop table reservation;");
		} catch (Exception e)  {
			e.printStackTrace();
		} finally {
			JDBCManagerV3.close(stmt);
			JDBCManagerV3.close(conn);
		}
	}
}

