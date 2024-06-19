<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Stock Ratings</title>
  </head>

  <body>
    <h1>Stock Ratings</h1>

    <%@ page import="java.util.*" %>
    <%
    ArrayList stocks = (ArrayList) request.getAttribute("data");
    if (stocks != null && stocks.size() > 0) {
    %>
    <form action="AddRating" method="post">
      <table border="1">
          <tr>
            <th>Ticker</th>
            <th>Analyst</th>
            <th>Rating</th>
          </tr>
      <%
      for (int i = 0; i < stocks.size(); i++) {
        Vector v = (Vector) stocks.get(i);
        String ticker = (String)v.elementAt(0);
        String analyst = (String)v.elementAt(1);
        String rating = (String)v.elementAt(2);
      %>
      <tr>
        <td><%= ticker %></td>
        <td><%= analyst %></td>
        <td><%= rating %></td>
      </tr>
      <%
      }
      %>
    </table>
    <table>
          <tr>
            <td>
              <select name="analysts">
                <%
                ArrayList analysts =
                  (ArrayList) request.getAttribute("analysts");
                for (int i = 0; i < analysts.size(); i++) {
                  String analyst = (String)analysts.get(i);
                %>
                <option value="<%= analyst %>">
                  <%= analyst %>
                  <%
                  }
                  %>
              </select>
            </td>
            <td>
              <select name="stocks">
                <%
                ArrayList unratedStocks =
                  (ArrayList) request.getAttribute("unrated");
                for (int i = 0; i < unratedStocks.size(); i++) {
                  String ticker = (String)unratedStocks.get(i);
                %>
                <option value="<%= ticker %>">
                  <%= ticker %>
                  <%
                  }
                  %>
              </select>
            </td>
            <td>
              <select name="ratings">
                <option value="Run away! Run away!">Run away! Run away!
                <option value="Could be worse!">Could be worse!
                <option value="A bit of OK!">A bit of OK!
                <option value="Take a chance!">Take a chance!
                <option value="Smashing!">Smashing!
              </select>
            </td>
          </tr>
          <tr>
            <td>
              <input type="submit" value="Submit Rating">
            </td>
          </tr>
      </table>
    </form>
    <%
    } else {
    %>
    No stock information found
    <%
    }
    %>
  </body>
</html>
