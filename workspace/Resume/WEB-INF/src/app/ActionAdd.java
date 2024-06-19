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

public class ActionAdd extends Action {
	
	synchronized public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
        throws IOException, ServletException, HibernateException {

		AddForm addForm = (AddForm) form;
		HttpSession userSession = request.getSession();
		request.setAttribute("listStates", addForm.listStates);
		request.setAttribute("listMth", addForm.listMth);
		request.setAttribute("listDay", addForm.listDay);
		request.setAttribute("listYr", addForm.listYr);
		request.setAttribute("listCurrEmpl", addForm.listCurrEmpl);
		request.setAttribute("listGender", addForm.listGender);
		return (mapping.findForward("success"));
	}
	
}
