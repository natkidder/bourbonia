package jdbc;

import java.sql.*;

public class JDBCClient5  {
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rset = null;

	static String sqlTrunc = "truncate countries;";
	static String sqlInsert = "insert into countries (country, country_iso_code, region) values (?, ?, ?);";
	static String sqlQry = "select * from countries;";

	public static void main(String args[])  {
		try  {
			String url = "jdbc:mysql://localhost:3306/testdb";
			String user = "nkidder";
			String pwd = "wlypb";
			conn = JDBCManagerV3.getConnection(url, user, pwd, false);
			pstmt = conn.prepareStatement(sqlInsert);

			// transaction begins here
			cleanupTbl();
			doEHBatch();
			doWHBatch();
			utils.prtln("\nChecking the table before commit or rollback: ");
			doQuery();

			// pretend we need to roll back
			JDBCManagerV3.rollback(conn);
			utils.prtln("\nChecking the table after rollback: ");
			doQuery();
			JDBCManagerV3.close(pstmt);

			pstmt = conn.prepareStatement(sqlInsert);
			doEHBatch();
			doWHBatch();
			conn.commit();
			utils.prtln("\nChecking the table after commit:");
			doQuery();
		} catch (SQLException e)  {
			JDBCManagerV3.rollback(conn);
			e.printStackTrace();
		} catch (Exception e)  {
			e.printStackTrace();
		} finally {
			JDBCManagerV3.close(rset);
			JDBCManagerV3.close(pstmt);
			JDBCManagerV3.close(conn);
		}
	}

	public static void cleanupTbl()  {
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlTrunc);
			conn.commit();
		} catch (SQLException e) {
			JDBCManagerV3.rollback(conn);
			e.printStackTrace();
		} finally  {
			JDBCManagerV3.close(stmt);
		}
	}

	public static void doEHBatch() throws SQLException  {
		pstmt.setString(1, "Norway");
		pstmt.setString(2, "NW");
		pstmt.setString(3, "Europe");
		pstmt.addBatch();

		pstmt.setString(1, "Mozambique");
		pstmt.setString(2, "MZ");
		pstmt.setString(3, "Africa");
		pstmt.addBatch();

		pstmt.setString(1, "Vietnam");
		pstmt.setString(2, "VN");
		pstmt.setString(3, "Asia");
		pstmt.addBatch();

		pstmt.executeBatch();
	}

	public static void doWHBatch() throws SQLException {
		pstmt.setString(1, "Honduas");
		pstmt.setString(2, "HN");
		pstmt.setString(3, "North America");
		pstmt.addBatch();

		pstmt.setString(1, "Uruguay");
		pstmt.setString(2, "UG");
		pstmt.setString(3, "South America");
		pstmt.addBatch();
		
		pstmt.executeBatch();
	}

	public static void doQuery() throws SQLException  {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sqlQry);
			int rownum = 1;

			if (rset.next())  {
				do  {
					utils.prtln("row " + rownum + " is " + rset.getString(1) + ", " + rset.getString(2) + ", " + rset.getString(3));
				} while (rset.next());
			} else {
				utils.prtln("no rows in the countries table");
			}
		} catch(SQLException e)  {
			e.printStackTrace();
		} finally {
			JDBCManagerV3.close(rset);
			JDBCManagerV3.close(stmt);
		}
	}
}
