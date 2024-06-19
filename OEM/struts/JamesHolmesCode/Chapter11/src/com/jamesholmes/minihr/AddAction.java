package com.jamesholmes.minihr;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class AddAction extends Action
{
  public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception
  {
    EmployeeSearchService service = new EmployeeSearchService();
    ArrayList results;

    AddForm addForm = (AddForm) form;

    // Perform employee search based on what criteria was entered.
    String name = addForm.getName();
    String ssNum = addForm.getSsNum();
    EmployeeSearchService.addEmployee(name, ssNum);

    // Forward control to this Action's input page.
    return mapping.findForward("success");
  }
}
