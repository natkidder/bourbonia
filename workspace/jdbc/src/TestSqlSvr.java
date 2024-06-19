import java.sql.*;

public class TestSqlSvr {
	static final String sqlCreate = "create table testTbl (testCol varchar(100))";
	static final String sqlTruncate = "truncate table testTbl";
	static final String sqlInsert = "insert into testTbl (testCol) values (?)";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try  {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			DriverManager.setLoginTimeout(15);
//			String url = "jdbc:microsoft:sqlserver://192.168.10.92:1433;databaseName=natResume";
			String url = "jdbc:jtds:sqlserver://192.168.10.92:1433/natResume";
			Connection conn = DriverManager.getConnection(url,"sa","pwd123");		
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sqlCreate);
			stmt.executeUpdate(sqlTruncate);
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, "testCol_testValue");
			pstmt.addBatch();
			int[] i = pstmt.executeBatch();
		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
