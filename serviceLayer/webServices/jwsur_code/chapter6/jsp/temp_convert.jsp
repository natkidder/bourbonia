<%@ page errorPage = 'error.jsp' %>
<%@ page import = 'client.TempConvert' %>
<%@ page import = 'client.TempConvertService' %>
<html><body>
<%! private float f2c, c2f, temp; %>
<%
   String temp_str = request.getParameter("temperature");
   if (temp_str != null) temp = Float.parseFloat(temp_str.trim());

   TempConvertService service =  new TempConvertService();
   TempConvert port = service.getTempConvertPort();
   f2c = port.f2C(temp);
   c2f = port.c2F(temp);
%>
<p><%= this.temp %>F = <%= this.f2c %>C</p>
<p><%= this.temp %>C = <%= this.c2f %>F</p>
<a href = 'index.html'>Try another</a>
</body></html>
