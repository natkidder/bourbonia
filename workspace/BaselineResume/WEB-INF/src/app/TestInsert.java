package app;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class TestInsert extends HttpServlet {
	static final String sqlTruncate = "truncate table testTbl";
	static final String sqlInsert = "insert into resume " +
"(firstName, mi, lastName, currEmployed, street, apt, city, state, zip, home, office, cell, " +
"workCity, workState, email, IM, birthDt, gender, lowSalary, highSalary, relocation, comments, " + 
"skill, yearsExp, resumeFile) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doInsert(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doInsert(req, resp);
	}
	public void doInsert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try  {
			PrintWriter pw = resp.getWriter();
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			DriverManager.setLoginTimeout(15);
//			String url = "jdbc:microsoft:sqlserver://192.168.10.92:1433;databaseName=natResume";
			String url = "jdbc:jtds:sqlserver://192.168.10.92:1433/natResume";
			conn = DriverManager.getConnection(url,"sa","pwd123");		
			pstmt = conn.prepareStatement(sqlInsert);

            pstmt.setString(1, req.getParameter("firstName"));
            pstmt.setString(2, req.getParameter("mi").substring(0,1));
            pstmt.setString(3, req.getParameter("lastName"));
            pstmt.setString(4, req.getParameter("currEmployed"));
            pstmt.setString(5, req.getParameter("street"));
            pstmt.setString(6, req.getParameter("apt"));
            pstmt.setString(7, req.getParameter("city"));
            pstmt.setString(8, req.getParameter("state"));
            pstmt.setString(9, req.getParameter("zip"));
            pstmt.setString(10, req.getParameter("home"));
            pstmt.setString(11, req.getParameter("office"));
            pstmt.setString(12, req.getParameter("cell"));
            pstmt.setString(13, req.getParameter("workCity"));
            pstmt.setString(14, req.getParameter("workState"));
            pstmt.setString(15, req.getParameter("email"));
            pstmt.setString(16, req.getParameter("IM"));
            pstmt.setString(17, req.getParameter("birthDt"));
            pstmt.setString(18, req.getParameter("gender"));
            pstmt.setString(19, req.getParameter("lowSalary"));
            pstmt.setString(20, req.getParameter("highSalary"));
            pstmt.setString(21, req.getParameter("relocation"));
            pstmt.setString(22, req.getParameter("comments"));
            pstmt.setString(23, req.getParameter("skill"));
            pstmt.setString(24, req.getParameter("yearsExp"));

     		pstmt.addBatch();
			int[] i = pstmt.executeBatch();
			pw.print("<br><p>rows inserted: " + i[0] + "</p>");

		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			    pstmt.close();
			    conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
