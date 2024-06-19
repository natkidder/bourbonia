package web;

import javax.servlet.*;
import java.io.*;

public class LogA implements Filter  {

	public void init(FilterConfig filterConfig)   {}

	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException   {
		String filename = "c:/Users/nat/LogA.txt";
		FileWriter fileWriter = new FileWriter(filename);
		PrintWriter printWriter = new PrintWriter(fileWriter, true);
		printWriter.println("LogA passing request to next filter, LogB");

		try  {
			chain.doFilter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		printWriter.println("The servlet has processed the request");
		printWriter.println("LogA filter is now working to process the response");
	}

	public void destroy()  {}

	private void prtln(String s) { System.out.println(s); }
}
