package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ActionFind extends Action {

	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
        throws IOException, ServletException {

		ResumeForm resumeForm = (ResumeForm) form; 
		request.setAttribute("listStates", resumeForm.listStates);
		request.setAttribute("listMth", resumeForm.listMth);
		request.setAttribute("listDay", resumeForm.listDay);
		request.setAttribute("listYr", resumeForm.listYr);
		request.setAttribute("listCurrEmpl", resumeForm.listCurrEmpl);
		request.setAttribute("listGender", resumeForm.listGender);
		return (mapping.findForward("success"));

	}
}
