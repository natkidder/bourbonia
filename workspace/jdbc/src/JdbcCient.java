
import java.io.*;
import java.sql.*;

public class JdbcCient {

	/**
	 * @param args
	 */
		// TODO Auto-generated method stub
		static Connection conn = null;
		static Statement stmt = null;
		static PreparedStatement pstmt = null;
		static ResultSet rset = null;

		static String sqlTrunc = "truncate contacts";
		static String sqlInsert = "insert into contacts (fname, lname, state, age) values ( ?, ?, ?, ?)";
		static String sqlQry = "select fname, lname, state, age from contacts";

		public static void main(String[] args)  {
			try {
				String url = "jdbc:mysql://localhost/nkidder";
				String username = "nkidder";
				String password = "java1";
				conn = JDBCManager.getConnection(url, username, password);
				conn.setAutoCommit(true);
				doBatch();
				doQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e)  {
				e.printStackTrace();
			} finally {
				JDBCManager.close(rset);
				JDBCManager.close(pstmt);
				JDBCManager.close(stmt);
				JDBCManager.close(conn);
			}
		}

		public static void doBatch() throws SQLException, IOException  {
			FileReader InFile = new FileReader("in.txt");
			BufferedReader input = new BufferedReader(InFile);
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(sqlTrunc);			
			String line;
			String[] fields;
			pstmt = conn.prepareStatement(sqlInsert);
			while( (line = input.readLine()) != null ) {
				// System.out.println(line);
				fields = line.split("\\:");
				pstmt.setString(1, fields[0]);
				pstmt.setString(2, fields[1]);
				pstmt.setString(3, fields[2]);
				pstmt.setString(4, fields[3]);
				pstmt.addBatch();
			}

			int[] counts = pstmt.executeBatch();
			utils.prtln("Results of inserts (should be 1 for each): ");
			for (int j=0; j<counts.length; j++)  {
				System.out.println(counts[j]);
			}
		}

		public static void doQuery() throws SQLException, IOException {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sqlQry);
			utils.prtln("Checking the table...");
			FileWriter OutFile = new FileWriter("c:/nat/out.txt");
			PrintWriter output = new PrintWriter(OutFile,true);
			int rownum = 1;
			rset.beforeFirst();  
			while (rset.next())  {  
//				utils.prtln(rset.getString(1) + ", " + rset.getString(2) + ", " + rset.getString(3));
				output.println("First Name: " + rset.getString(1));
				output.println("Last Name: " + rset.getString(2));
				output.println("State: " + rset.getString(3));
				output.println("Age: " + rset.getString(4));
				output.println("");
			}
		}

}


