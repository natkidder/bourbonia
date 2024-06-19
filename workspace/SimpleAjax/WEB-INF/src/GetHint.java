import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

public class GetHint extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;  // innoculates against certain errors

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			      throws java.io.IOException {
			  String q = req.getParameter("q");
			  String match = "";
			  
			  if (q != null) {
				int len=q.length();
				ArrayList<String> names = createNames();
				for (String name : names)  {
					if (name.length() > len)  {
						if (name.substring(0, len).equalsIgnoreCase(q)) {
							match += name + " ";
						}
					}
				}
			  }

			  // Write text to response
//			  res.setContentType("text/html");  // this would generate an entire page
			  System.out.println(match); ////
			  res.getWriter().write(match);
			}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws java.io.IOException {
		doPost(req, res);
	}
	
	public ArrayList createNames()  {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anna");
		names.add("Brittany");
		names.add("Cinderella");
		names.add("Diana");
		names.add("Eva");
		names.add("Fiona");
		names.add("Gunda");
		names.add("Hege");
		names.add("Inga");
		names.add("Johanna");
		names.add("Kitty");
		names.add("Linda");
		names.add("Nina");
		names.add("Ophelia");
		names.add("Petunia");
		names.add("Amanda");
		names.add("Raquel");
		names.add("Cindy");
		names.add("Doris");
		names.add("Eve");
		names.add("Evita");
		names.add("Sunniva");
		names.add("Tove");
		names.add("Unni");
		names.add("Violet");
		names.add("Liza");
		names.add("Elizabeth");
		names.add("Ellen");
		names.add("Wenche");
		names.add("Vicky");
		return names;
	}
}
