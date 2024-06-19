import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class upLoadFileCodeNew extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws IOException {
		try {
			String[] s;
			ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
			List fileItemsList = servletFileUpload.parseRequest(request);
			Iterator it = fileItemsList.iterator();

			while (it.hasNext()) {
				FileItem fileItem = (FileItem) it.next();
				String name = fileItem.getFieldName();
				String loc = fileItem.getName();
				String name_of_file = splitIt(loc);
				s = getExtension(name_of_file);
				String name_of_file1 = s[0];
				String extension = s[1];
				System.out.println(name_of_file);
				System.out.println("File field " + name + " with file name "
						+ fileItem.getName() + " detected.");
				String orgFile = "C://Downloads//" + name_of_file;
				Calendar c = Calendar.getInstance();
				String extFile = name_of_file1 + c.getTimeInMillis();
				String newFile = "C://Downloads//" + extFile + "." + extension;

				File saveTo = new File(orgFile);

				if (saveTo.exists()) 
				{
					File saveTo1 = new File(newFile);
					fileItem.write(saveTo1);
					System.out.println("File Save to your location!");
					intoDB(newFile, extFile);

				} else 
				{

					fileItem.write(saveTo);
					System.out.println("File Save to your location!");
					intoDB(orgFile, name_of_file);
				}
				PrintWriter out = resp.getWriter();
				out.println("<html><body>");
				out.println(name_of_file1 +" has been successfully uploaded!");
				out.println("<br>");
				out.println("<a href = 'menu.html'> BACK TO MENU </a>");
				out.println("</body></html>");
			}
		} 
		catch (FileUploadException e) 
		{
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void intoDB(String filename, String PartName) {
		System.out.println("Insert Image Example!");
		String driverName = "net.sourceforge.jtds.jdbc.Driver";
		String url = "jdbc:jtds:sqlserver://localhost:1433/";
		String dbName = "training";
		String userName = "sa";
		String password = "pwd123";
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url + dbName, userName, password);
			PreparedStatement pre = con
					.prepareStatement("insert into fileupload values(?,?)");
			pre.setString(1, PartName);
			pre.setString(2, filename);
			pre.executeUpdate();
			System.out.println("Inserting Successfully!");
			pre.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	String splitIt(String loc) {
		String ss = loc.replaceAll("\\\\", "/");
		System.out.println(ss);
		String[] s = ss.split("/");
		return s[(s.length - 1)];
	}

	String[] getExtension(String filename) {
		String[] s = filename.split("\\.");
		return s;
	}
}
