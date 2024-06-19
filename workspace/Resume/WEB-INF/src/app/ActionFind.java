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

		System.out.println("Resume.ActionFind.ActionForward"); ////
		FindForm findForm = (FindForm) form; 

		request.setAttribute("listStates", findForm.listStates);
		request.setAttribute("listMth", findForm.listMth);
		request.setAttribute("listDay", findForm.listDay);
		request.setAttribute("listYr", findForm.listYr);
		request.setAttribute("listCurrEmpl", findForm.listCurrEmpl);
		request.setAttribute("listGender", findForm.listGender);

		String step = findForm.getStep();
		if (step == null) { return mapping.findForward("failure"); }
		if (step.equals("Login"))  { 
			System.out.println("Resume.ActionFind.ActionForward, step = " + step);
			
			// code below may be superfluous
/*
			HttpSession userSession = request.getSession(false);
			Resume resume = (Resume) userSession.getAttribute("resumeFromFindForm");
			System.out.println("ActionFind.ActionForward, resumeFromFindForm.email: " + resume.getEmail()); ////
			ResumeUpdForm resumeUpdForm = (ResumeUpdForm) form;
			findForm = Utilities.rtnFindForm(findForm, resume);
*/
			return (mapping.findForward("success"));
		} else if (step.equals("Home")) {
			return mapping.findForward("home");
		} else {
			return (mapping.findForward("failure"));
		}


	}
}
