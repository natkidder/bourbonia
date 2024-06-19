package jdbc;

import java.sql.*;

public class JDBCClient1  {
	static Connection conn = null;
	static Statement stmt = null;

	static String sqlCreateTbl = "create table countries (country varchar(26), country_iso_code varchar(2) not null, region varchar(26));";
	static String sqlInsert = "insert into countries (country, country_iso_code, region) values ('Albania', 'AL', 'Europe');";
	static String sqlUpdate = "update countries set country_iso_code = 'AB' where country = 'Albania';";
	static String sqlDelete = "delete from countries where country='Albania';";
	static String sqlDropTbl = "drop table countries;";

	static int result;

	public static void main(String[] args)  {
		try  {
			String url = "jdbc:mysql://localhost/testdb";
			String username = "nat";
			String password = "";
			conn = JDBCManagerV1.getConnection(url, username, password);
			stmt = conn.createStatement();

			createTable();
			doInsert();
			doUpdate();
			doDelete();
			dropTable();
			doBatch();
		} catch (SQLException e)  {
			e.printStackTrace();
		} catch (Exception e)  {
			e.printStackTrace();
		} finally  {
			JDBCManagerV1.close(stmt);
			JDBCManagerV1.close(conn);
		}
	}

	public static void createTable() throws SQLException {
		result = stmt.executeUpdate(sqlCreateTbl);
		utils.prtln("Create affected " + result + " rows (expected 0)");
	}

	public static void doInsert() throws SQLException  {
		result = stmt.executeUpdate(sqlInsert);
		utils.prtln("Inserted " + result + " rows (expected 1)");
	}

	public static void doUpdate() throws SQLException   {
		result = stmt.executeUpdate(sqlUpdate);
		utils.prtln("Updated " + result + " rows (expected 1)");
	}

	public static void doDelete() throws SQLException  {
		result = stmt.executeUpdate(sqlDelete);
		utils.prtln("Deleted " + result + " rows (expected 1)");
	}

	public static void dropTable() throws SQLException   {
		result = stmt.executeUpdate(sqlDropTbl);
		utils.prtln("Drop affected " + result + " rows (expected 0)");
	}

	public static void doBatch() throws SQLException  {
		stmt.addBatch(sqlCreateTbl);
		stmt.addBatch(sqlInsert);
		stmt.addBatch(sqlUpdate);
		stmt.addBatch(sqlDelete);
		stmt.addBatch(sqlDropTbl);

		int[] results = stmt.executeBatch();
		for (int i=0; i < results.length; i++) {
			utils.prtln("operation affected " + results[i] + " rows");
		}
	}
}
