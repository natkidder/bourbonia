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

public final class ActionResume extends Action {

	synchronized public ActionForward execute(ActionMapping mapping,
	            ActionForm form,
	            HttpServletRequest request,
	            HttpServletResponse response)
	        throws IOException, ServletException, HibernateException {

		System.out.println("BaselineResume.ActionResume.ActionForward"); ////
		HttpSession userSession = request.getSession();
		ResumeForm resumeForm = (ResumeForm) form; 
		request.setAttribute("listStates", resumeForm.listStates);
		request.setAttribute("listMth", resumeForm.listMth);
		request.setAttribute("listDay", resumeForm.listDay);
		request.setAttribute("listYr", resumeForm.listYr);
		request.setAttribute("listCurrEmpl", resumeForm.listCurrEmpl);
		request.setAttribute("listGender", resumeForm.listGender);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		String step = resumeForm.getStep();
		if (step == null) { return (mapping.findForward("failure")); }  //// may need to change
			try {
				tx = session.beginTransaction();
				Resume resume = new Resume();
				resume = Utilities.setResume(resumeForm, resume);

				if (step.equals("Insert"))  {
					session.save(resume);
					Utilities.writeToDisk(resume.getEmail(), resumeForm.getFileSelected());
					tx.commit();
					return (mapping.findForward("inserted"));	
				} else if (step.equals("Update"))  {
					session.update(resume);
					Utilities.writeToDisk(resume.getEmail(), resumeForm.getFileSelected());
					tx.commit();
					ActionErrors errors = ResultMsg("updated");  // does nothing
					return (mapping.findForward("updated"));						
				} else if (step.equals("Remove")) {
//					System.out.println("resumeForm.getFirstName(): " + resumeForm.getFirstName()); ////					
//					System.out.println("resumeForm.getId(): " + resumeForm.getId()); ////
//					System.out.println("resume.getId(): " + resume.getId()); ////
					tx = session.beginTransaction();
					session.delete(resume);
					tx.commit();
					return mapping.findForward("deleted");
				} else if (step.equals("Find")) {
					Resume tmpResume = new Resume();
					tmpResume.setEmail(resume.getEmail());
					Example example = Example.create(tmpResume);
					example.excludeProperty("currEmployed");
					example.excludeProperty("state");
					example.excludeProperty("gender");
					example.excludeProperty("workState");
					example.excludeProperty("employed");
//					System.out.println(example.toString());   ////
					Criteria criteria = session.createCriteria(Resume.class);
					criteria.add(example);
					criteria.addOrder(Order.asc("lastName"));
					List resumeList = criteria.list();
					if (resumeList.size() == 0)  {
						return (mapping.findForward("add"));
					}
//					System.out.println("resumeList size: " + resumeList.size()); ////
					for (ListIterator li = resumeList.listIterator(); li.hasNext();)  {
						Resume res = (Resume)li.next();
//						System.out.println(res.getFirstName() + "," + res.getState() + "," + res.getCurrEmployed() + "," + res.getGender() + "," + res.getWorkState() + "," + res.getSkill()); ////
						resumeForm = Utilities.setResumeForm(resumeForm, res);
					}
					return (mapping.findForward("found"));
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
