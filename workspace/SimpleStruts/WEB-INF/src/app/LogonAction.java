
package app;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class LogonAction extends Action {

    /**
     * Validate credentials with business tier.
     *
     * @param username The username credential
     * @param password The password credential
     * @returns true if credentials can be validated
     * @exception UserDirectoryException if cannot access directory
     */
    public boolean isUserLogon(String username, String password) 
    {
    	if ( username.equals("abc") && password.equals("123"))
    		return true;
    	else
    		return false;
    }


    /**
     * Login the user.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param actionForm The ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet exception occurs
     */
    public ActionForward perform(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
        throws IOException, ServletException {

        // Obtain username and password from web tier
        String username = ((LogonForm) form).getUsername();
        String password = ((LogonForm) form).getPassword();

        // Validate credentials with business tier
        boolean validated = false;
        try {

            validated = isUserLogon(username,password);
        }

        catch (Exception e) {
            // couldn't connect to user directory
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.logon.connect"));
            saveErrors(request,errors);
            // return to input page
            return (new ActionForward(mapping.getInput()));
        }

        if (!validated) {
            // credentials don't match
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_ERROR,
            new ActionError("error.logon.invalid"));
            saveErrors(request,errors);
            // return to input page
            return (new ActionForward(mapping.getInput()));
        }

        // Save our logged-in user in the session,
        // because we use it again later.
        HttpSession session = request.getSession();
        session.setAttribute("user", form);

        // Return success
        return (mapping.findForward("success"));

    }

} // End LogonAction
