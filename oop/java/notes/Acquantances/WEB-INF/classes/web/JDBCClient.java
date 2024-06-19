package web;

import java.sql.*;
import java.util.*;

public class JDBCClient  {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rset = null;

	static String sqlQry = "select f_name, l_name, mi, street, street2, city, state, zip, h_phone, d_phone, email, spouse, comments " +
						   "from acquantances where street != '' order by l_name";

	public static ArrayList<Acquantance> createAcqs(String user, String pwd)  {
		ArrayList<Acquantance> acqs = new ArrayList<Acquantance>();
		try {
			String url = "jdbc:mysql://localhost/acquantances";
			conn = JDBCManager.getConnection(url, user, pwd);
			stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
			rset = stmt.executeQuery(sqlQry);
			acqs = addAcq(rset);
		} catch(SQLException e)  {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCManager.close(rset);
			JDBCManager.close(stmt);
			JDBCManager.close(conn);
			return acqs;
		}
	}

	public static ArrayList<Acquantance> addAcq(ResultSet rset) throws SQLException  {
		ArrayList<Acquantance> acqList = new ArrayList<Acquantance>();
		try {
			rset.beforeFirst();
			while (rset.next())  {
				Acquantance acq = new Acquantance();
				acq.setFname(rset.getString(1));
				acq.setLname(rset.getString(2));
				acq.setMi(rset.getString(3));
				acq.setStreet(rset.getString(4));
				acq.setStreet2(rset.getString(5));
				acq.setCity(rset.getString(6));
				acq.setState(rset.getString(7));
				acq.setZip(rset.getString(8));
				acq.setHphone(rset.getString(9));
				acq.setDphone(rset.getString(10));
				acq.setEmail(rset.getString(11));
				acq.setSpouse(rset.getString(12));
				acq.setComments(rset.getString(13));
				acqList.add(acq);	
			}
		} catch (SQLException e)  {
			e.printStackTrace();
		} catch (Exception e)  {
			e.printStackTrace();
		} finally {
			return acqList;
		}
	}
}
