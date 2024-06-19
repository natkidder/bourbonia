package jdbc;

import java.sql.*;

public class JDBCClient3  {
	static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static ResultSet rset = null;

	static String sqlTrunc = "truncate countries";
	static String sqlInsert = "insert into countries (country, country_iso_code, region) values ( ?, ?, ?)";
	static String sqlQry = "select * from countries";

	public static void main(String[] args)  {
		try {
			String url = "jdbc:mysql://localhost/testdb";
			String username = "nat";
			String password = "";
			conn = JDBCManagerV2.getConnection(url, username, password);
			conn.setAutoCommit(false);
			doBatch();
			doQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e)  {
			e.printStackTrace();
		} finally {
			JDBCManagerV2.close(rset);
			JDBCManagerV2.close(pstmt);
			JDBCManagerV2.close(stmt);
			JDBCManagerV2.close(conn);
		}
	}

	public static void doBatch() throws SQLException  {

		stmt = conn.createStatement();
		int i = stmt.executeUpdate(sqlTrunc);

		pstmt = conn.prepareStatement(sqlInsert);

		pstmt.setString(1, "France");
		pstmt.setString(2, "FR");
		pstmt.setString(3, "Eurasia");
		pstmt.addBatch();

		pstmt.setString(1, "Gabon");
		pstmt.setString(2, "GB");
		pstmt.setString(3, "Africa");
		pstmt.addBatch();

		pstmt.setString(1, "NewZealand");
		pstmt.setString(2, "NZ");
		pstmt.setString(3, "Oceana");
		pstmt.addBatch();

		pstmt.setString(1, "Canada");
		pstmt.setString(2, "CA");
		pstmt.setString(3, "North America");
		pstmt.addBatch();

		pstmt.setString(1, "Columbia");
		pstmt.setString(2, "CO");
		pstmt.setString(3, "South America");
		pstmt.addBatch();

		int[] counts = pstmt.executeBatch();
		utils.prtln("Results of inserts (should be 1 for each): ");
		for (i = 0; i < counts.length; i++)  {
			utils.prtln(counts[i]);
		}
	}

	public static void doQuery() throws SQLException {
		stmt = conn.createStatement();
		rset = stmt.executeQuery(sqlQry);
		utils.prtln("Checking the table...");
		int rownum = 1;
		rset.beforeFirst();  // unneccessary, but ensures you're at the beginning
		while (rset.next())  {  
			utils.prt("row " + rownum + " is " );
			utils.prtln(rset.getString(1) + ", " + rset.getString(2) + ", " + rset.getString(3));
		}
	}

}
