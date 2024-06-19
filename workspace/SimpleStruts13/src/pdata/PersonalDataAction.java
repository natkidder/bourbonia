package pdata;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm; 

public class PersonalDataAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
		    HttpServletRequest request, HttpServletResponse response) {
		
		PersonalData pd = (PersonalData) form;
		if (form != null) { 
		    return (mapping.findForward(Constants.SUCCESS_KEY)); 
		} else { 
		    return (mapping.findForward(Constants.FAILURE_KEY)); 
		}
	}
}
