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

public final class ActionUpdResume extends Action {

	synchronized public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws IOException, ServletException, HibernateException {

		ResumeUpdForm resumeUpdForm = (ResumeUpdForm) form; // the form is what was spec'd in your Action element
		HttpSession userSession = request.getSession();
		Boolean isContinuingUpd = (Boolean) userSession.getAttribute("continueUpdate");
		if (isContinuingUpd == null) 
			isContinuingUpd = false;
		Resume sessionResume = (Resume) userSession.getAttribute("resumeFromFindForm");
		request.setAttribute("listStates", resumeUpdForm.listStates);
		request.setAttribute("listMth", resumeUpdForm.listMth);
		request.setAttribute("listDay", resumeUpdForm.listDay);
		request.setAttribute("listYr", resumeUpdForm.listYr);
		request.setAttribute("listCurrEmpl", resumeUpdForm.listCurrEmpl);
		request.setAttribute("listGender", resumeUpdForm.listGender);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		String step = resumeUpdForm.getStep();
		Utilities.pl("ActionUpdResume.execute step="+step); ////
		if (step == null) { return (mapping.findForward("failure")); }  //// may need to change
		try {
			session.clear();
			tx = session.beginTransaction();
			Resume resume = new Resume();
			resume = Utilities.rtnResume(resumeUpdForm, resume);  // MIGHT NOT WORK

			if (step.equals("Login") || isContinuingUpd) {// && ! isContinuingUpd) {
				System.out.println("ActionUpdResume.ActionForward--step = " + step); ////
				Resume tmpResume = new Resume();
				tmpResume.setEmail(resume.getEmail()); // ASSUMES already authenticated
				Example example = Example.create(tmpResume);
				example.excludeProperty("currEmployed");
				example.excludeProperty("state");
				example.excludeProperty("gender");
				example.excludeProperty("workState");
				example.excludeProperty("employed");
				//				System.out.println(example.toString());   ////
				Criteria criteria = session.createCriteria(Resume.class);
				criteria.add(example);
				criteria.addOrder(Order.asc("lastName"));
				List resumeList = criteria.list();
				System.out.println("ActionUpdResume.ActionForward.find: resumeList.size = " + resumeList.size());   ////
				if (resumeList.size() == 0)  {
					return (mapping.findForward("failure"));
				}
				for (ListIterator li = resumeList.listIterator(); li.hasNext();)  {
					Resume res = (Resume)li.next();
//					res = (Resume) userSession.getAttribute(resume.getEmail() + "resumeFromFindForm"); // if this works, remove the whole lookup as it's too expensive
					resumeUpdForm = Utilities.rtnResumeForm(resumeUpdForm, res);  // MIGHT NOT WORK
				}
				userSession.setAttribute("lastEvent", "found");
				return (mapping.findForward("found"));

			} else if (step.equals("Update"))  {
				session.update(resume);  // must have Id set for this to work
				Utilities.pl("ActionUpdResume.ActionForward.Update isContinuingUpd="+isContinuingUpd); ////
				userSession.setAttribute("resumeFromFindForm", resume);
				Utilities.pl("ActionUpdResume.ActionForward.Update resume.Id=" + resume.getId()); ////
				Utilities.writeToDisk(resume.getEmail(), resumeUpdForm.getFileSelected());
				tx.commit();  
				return (mapping.findForward("updated"));   //return (mapping.findForward("updated"));						
			} else if (step.equals("Remove")) {
				Utilities.removeFromDisk(resume.getEmail()); //deletes entire directory tree
				//					System.out.println("resumeUpdForm.getFirstName(): " + resumeUpdForm.getFirstName()); ////
				Login login = Utilities.rtnLogin(session, resume.getEmail());
				tx = session.beginTransaction();
				if (login != null) {
					session.delete(login);
				} else {
					Utilities.pl("Login with email " + resume.getEmail() + " not removed");
				}
				session.delete(resume);
				tx.commit();
				return mapping.findForward("deleted");
			} else if (step.equals("Home")) {
				return (mapping.findForward("home"));
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

	public ActionErrors ResultMsg(String condition)  {
		ActionErrors errors = new ActionErrors();
		if (condition.equals("updated"))  {
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("success.form.updated"));
		}
		return errors;
	}
}
