package web;

import javax.servlet.*;
import java.io.*;

public class LogB implements Filter  {
	
	public void init(FilterConfig filterConfig) {}

	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
		FileWriter fileWriter = new FileWriter("c:/Users/nat/LogB.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter, true);

		printWriter.println("Entered LogB doFilter()");
		printWriter.println("request.getProtocol() is " + request.getProtocol() );
		printWriter.println("request.getRemoteHost is " + request.getRemoteHost() );
		printWriter.println("request.getContentType is " + request.getContentType() );
		printWriter.println("request.getContentLength is " + request.getContentLength() );
		printWriter.println("request.getParameter(\"username\") is " + request.getParameter("username"));
		try  {
			chain.doFilter(request, response);
		} catch (Exception e)  {
			e.printStackTrace();
		}
	}

	public void destroy() {}

	private void prtln(String s) { System.out.println(s); }
}
