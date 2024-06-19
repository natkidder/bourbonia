package jdbc;

import java.sql.*;

public class JDBCClient2  {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rset = null;

	static String sqlTrunc = "truncate countries;";
	static String sqlInsert0 = "insert into countries (country, country_iso_code, region) values ('France', 'FR', 'Europe');";
	static String sqlInsert1 = "insert into countries (country, country_iso_code, region) values ('China', 'CH', 'Asia');";
	static String sqlInsert2 = "insert into countries (country, country_iso_code, region) values ('Camaroon', 'CM', 'Africa');";
	static String sqlInsert3 = "insert into countries (country, country_iso_code, region) values ('New Zealand', 'NZ', 'Oceana');";
	static String sqlInsert4 = "insert into countries (country, country_iso_code, region) values ('Canada', 'CA', 'North America');";
	static String sqlInsert5 = "insert into countries (country, country_iso_code, region) values ('Columbia', 'CL', 'South America');";
	static String sqlQry = "select * from countries";

	public static void main(String[] args)  {
		try {
			String url = "jdbc:mysql://localhost/testdb";
			String user = "nat";
			String password = "";
			conn = JDBCManagerV2.getConnection(url, user, password);
			conn.setAutoCommit(false);
			// cursor can move either way but cannot see changes, and cannot update ResultSet
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
			
			doBatch();
			doQuery();
		} catch(SQLException e)  {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCManagerV2.close(rset);
			JDBCManagerV2.close(stmt);
			JDBCManagerV2.close(conn);
		}
	}

	public static void doBatch() throws SQLException {
		try {
			stmt.addBatch(sqlTrunc);
			stmt.addBatch(sqlInsert0);
			stmt.addBatch(sqlInsert1);
			stmt.addBatch(sqlInsert2);
			stmt.addBatch(sqlInsert3);
			stmt.addBatch(sqlInsert4);
			stmt.addBatch(sqlInsert5);
			int[] results = stmt.executeBatch();
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		}
	}

	public static void doQuery() throws SQLException  {
		rset = stmt.executeQuery(sqlQry);
		utils.prtln("rset.next() = " + rset.next());
		utils.prtln("Should be on first row: isFirst() = " + rset.isFirst());
		// move forward 2 rows
		rset.next();  rset.next();
		utils.prtln("row nbr should be 3, getRow() = " + rset.getRow());
		rset.next();
		utils.prt("row 4 - ");
		utils.prt(rset.getString(1) + " - ");
		utils.prt(rset.getString(2) + " - ");
		utils.prtln(rset.getString(3));
		rset.next(); rset.next();
		utils.prtln("Should be on last row: isLast() = " + rset.isLast());
		rset.previous();
		utils.prtln("Should NOT be on last row: isLast() = " + rset.isLast());
		rset.beforeFirst();
		utils.prtln("Should be before first row: isBeforeFirst() = " + rset.isBeforeFirst());
	}
}
