import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFile extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws IOException {

		String name = request.getParameter("df");
		Delete(request, resp, name);
	}

	public void Delete(HttpServletRequest req, HttpServletResponse res,String name) {
		String driverName = "net.sourceforge.jtds.jdbc.Driver";
		String url = "jdbc:jtds:sqlserver://localhost:1433/";
		String dbName = "training";
		String userName = "sa";
		String password = "pwd123";
		Connection con = null;
		try {
			PrintWriter out = res.getWriter();
			Class.forName(driverName);
			con = DriverManager.getConnection(url + dbName, userName, password);
			Statement stmt = con.createStatement();
			String sql = "Delete from fileupload where name = '" + name + "'";
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
			String fileName = "C://Downloads//"+name;
			File f1 = new File(fileName);
			boolean del = f1.delete();
			if(!del)
			{
				out.println("<html><body>");
				out.println(name +" <font color = 'red'>does not exist");
				out.println("<br>");
				out.println("<a href = 'menu.html'> BACK TO MENU </a>");
				out.println("</body></html>");
			}
			else
			{
				out.println("<html><body>");
				out.println(name +" has been successfully deleted!");
				out.println("<br>");
				out.println("<a href = 'menu.html'> BACK TO MENU </a>");
				out.println("</body></html>");
			}
	
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
