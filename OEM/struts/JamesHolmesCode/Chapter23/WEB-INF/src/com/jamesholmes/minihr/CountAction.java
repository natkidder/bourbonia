package com.jamesholmes.minihr;

import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class CountAction extends Action
{
  public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception
  {
    EmployeeSearchService service = new EmployeeSearchService();

    // Retrieve employee count.
    int employeeCount = service.getEmployeeCount();
    
    // Write employee count to HTTP response.
    PrintWriter out = response.getWriter();
    out.print(employeeCount);

    // Return null to inform the controller servlet
    // that the HTTP response has been handled.
    return null;
  }
}
