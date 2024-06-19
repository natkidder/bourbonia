package web;

import javax.servlet.http.*;
import java.io.*;

public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)  {
        String username = request.getParameter("username");
        try {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html><body>");
            writer.println("ch05-6:");
            writer.println("Thank you, " + username + ".  You are now logged into the system.");
            writer.println("</body></html>");
            writer.close();
        }
        catch (Exception e)  {
            e.printStackTrace();
        }
    }
}
