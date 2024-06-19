package web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class AddRating extends HttpServlet {
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
  {
    try {
      String analyst = request.getParameter("analysts");
      String ticker = request.getParameter("stocks");
      String rating = request.getParameter("ratings");
            
      Vector v = new Vector();
      v.add(analyst);
      v.add(ticker);
      v.add(rating);

      ArrayList ratings = (ArrayList)request.getAttribute("data");
      ratings.add(v);
            
      ArrayList unratedStocks =
        (ArrayList)request.getAttribute("unrated");
      unratedStocks.remove(unratedStocks.indexOf(ticker));
            
      ServletContext context = getServletContext();
      RequestDispatcher dispatcher = 
        context.getNamedDispatcher("RatingsForm");
      dispatcher.forward(request, response);
    } catch (Exception e) {
      log("Exception in AddRating.doPost()", e);
    }
  }
}
