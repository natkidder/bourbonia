package web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class StockListServlet extends HttpServlet {
  static ArrayList analysts = new ArrayList();
  static ArrayList unratedStocks = new ArrayList();
  static ArrayList ratings = new ArrayList();

  public void init() {
    analysts.add("Fred");
    analysts.add("Leonard");
    analysts.add("Sarah");
    analysts.add("Nancy");
    unratedStocks.add("ABC");
    unratedStocks.add("DDBC");
    unratedStocks.add("DDC");
    unratedStocks.add("FBC");
    unratedStocks.add("INT");
    unratedStocks.add("JIM");
    unratedStocks.add("SRI");
    unratedStocks.add("SRU");
    unratedStocks.add("UDE");
    unratedStocks.add("ZAP");
    Vector v = new Vector();
    v.add("Fred");
    v.add("ZZZ");
    v.add("Smashing!");
    ratings.add(v);      
  }

  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
  {
    doGet(request, response);
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
  {
    try {
      ArrayList data = null;
      RequestDispatcher dispatcher;
      ServletContext context = getServletContext();
      String name = request.getPathInfo();
      name = name.substring(1);

      if ("AnalystForm".equals(name)) {
        data = analysts;
        request.setAttribute("data", data);
      } else if ("RatingsForm".equals(name)) {
        request.setAttribute("data", ratings);
        request.setAttribute("analysts", analysts);
        request.setAttribute("unrated", unratedStocks);
      } else if ("AddRating".equals(name)) {
        request.setAttribute("data", ratings);
        request.setAttribute("analysts", analysts);
        request.setAttribute("unrated", unratedStocks);
      } else if ("ProcessAnalyst".equals(name)){
        //no attributes are needed for this resource
      } else {
        name = "Error";
      }	

      dispatcher = context.getNamedDispatcher(name);
      if (dispatcher == null) {
        dispatcher = context.getNamedDispatcher("Error");
      }	
      dispatcher.forward(request, response);
    } catch (Exception e) {
      log("Exception in StockListServlet.doGet()");
    }
  }
}
