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
import org.hibernate.HibernateException;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import java.util.*;

public class ActionSearch extends Action {
	
	synchronized public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
        throws IOException, ServletException, HibernateException {

		HttpSession userSession = request.getSession(true); // KEEP THIS
		
		/* for Ajax autohint for emails */
		// Add the end if you want autosuggest to work
		List<String> emails = new ArrayList(); // Utilities.showEmails("");
		Integer i = 0;
		for (String s : emails)  {
			i++;
			userSession.setAttribute(i.toString(), s);
		}
		userSession.setAttribute("0", i.toString());
		return (mapping.findForward("successForm"));
	}

	/* replaced by Utilities.showEmails */
    public List<String> showEmails(String text) {

        // Get the session factory we can use for persistence
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Ask for a session using the JDBC information we've configured
        Session session = sessionFactory.openSession();
        try {
        	Criteria criteria = session.createCriteria(Resume.class);
        	//criteria.add(Restrictions.like("title", "%" + text + "%").ignoreCase());
        	criteria.add(Property.forName("email").like("%" + text + "%").ignoreCase());
        	criteria.setProjection(Projections.projectionList().
        			add(Projections.property("email")));
        	List<String> emails = criteria.list();
        	return emails;
        } finally {
        	session.close();
            sessionFactory.close();
        }

    }
}
