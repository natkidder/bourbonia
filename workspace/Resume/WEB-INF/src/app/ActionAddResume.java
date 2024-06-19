package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

public final class ActionAddResume extends Action {

	synchronized public ActionForward execute(ActionMapping mapping,
	            ActionForm form,
	            HttpServletRequest request,
	            HttpServletResponse response)
	        throws IOException, ServletException, HibernateException {

		HttpSession userSession = request.getSession();
		Boolean isStarting = (Boolean) userSession.getAttribute("startRegistration");
		if (isStarting == null) 
			isStarting = false;
		ResumeAddForm resumeAddForm = (ResumeAddForm) form; 
		request.setAttribute("listStates", resumeAddForm.listStates);
		request.setAttribute("listMth", resumeAddForm.listMth);
		request.setAttribute("listDay", resumeAddForm.listDay);
		request.setAttribute("listYr", resumeAddForm.listYr);
		request.setAttribute("listCurrEmpl", resumeAddForm.listCurrEmpl);
		request.setAttribute("listGender", resumeAddForm.listGender);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		String step = resumeAddForm.getStep();

		if (step == null) { return (mapping.findForward("failure")); }  //// may need to change
			try {
				tx = session.beginTransaction();
				Resume resume = new Resume();
				resume = Utilities.rtnResume(resumeAddForm, resume); // polymorphism via method arguments
				if (step.equals("Submit") && ! isStarting)  {
					session.save(resume);
					Login login = new Login(resumeAddForm.getEmail(), Turnpike.genHash(resumeAddForm.getPasswd1()));
					session.save(login);
					tx.commit();
					return (mapping.findForward("inserted"));
				} else if (step.equals("Home")) {
					return (mapping.findForward("home"));
				} else if (step.equals("Register") || isStarting)  {
					userSession.setAttribute("startRegistration", false);
					resumeAddForm = (ResumeAddForm) userSession.getAttribute("resumeAddForm");
					return (mapping.findForward("StartRegistration"));
				} else {
					return (mapping.findForward("failure"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				try {
					if (session != null)  {
						session.close();
						sessionFactory.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
        // Save our logged-in user in the session,
        // because we use it again later.
     
        userSession.setAttribute("fname", form);
		return (mapping.findForward("failure"));
	}

}