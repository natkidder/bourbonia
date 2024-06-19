import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class retrieveFileCodeNew extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws IOException {

		String name = request.getParameter("rf");
		String[] s = getExtension(name);
		String name_of_file1 = s[0];
		String extension = s[1];
		outDB(request, resp, name, extension, name_of_file1);
	}

	public void outDB(HttpServletRequest req, HttpServletResponse res,
		String name, String extension, String filename) {
		String driverName = "net.sourceforge.jtds.jdbc.Driver";
		String url = "jdbc:jtds:sqlserver://localhost:1433/";
		String dbName = "training";
		String userName = "sa";
		String password = "pwd123";
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url + dbName, userName, password);
			Statement stmt = con.createStatement();
			String sql = "Select * from fileupload where name = '" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				String path = rs.getString("filepath");
				printOut(req, res, path, extension, filename);
			}
			else
			{
				PrintWriter out = res.getWriter();
				out.println("<html><body>");
				out.println(name +" <font color = 'red'>does not exist");
				out.println("<br>");
				out.println("<a href = 'menu.html'> BACK TO MENU </a>");
				out.println("</body></html>");
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	void printOut(HttpServletRequest req, HttpServletResponse res, String file,
			String ext, String filename) throws IOException {
		ServletOutputStream out = res.getOutputStream();

		res.setContentType("application/" + ext);
		String fileURL = "file:///" + file;

		res.setHeader("Content-disposition", "attachment; filename=" + filename
				+ "." + ext);

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			URL url = new URL(fileURL);

			bis = new BufferedInputStream(url.openStream());
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;

			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final MalformedURLException e) {
			System.out.println("MalformedURLException.");
			throw e;
		} catch (final IOException e) {
			System.out.println("IOException.");
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}

	String[] getExtension(String filename) {
		String[] s = filename.split("\\.");
		return s;
	}

}
