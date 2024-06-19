
package app;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public final class LogonForm extends ActionForm {

    private String password = null;

    private String username = null;

    public String getPassword() {
    	return (this.password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
    	return (this.username);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping,
        HttpServletRequest request) {

        setPassword(null);
        setUsername(null);

    }


    /**
     * Ensure that both fields have been input.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

        if ((username == null) || (username.length() < 1))
            errors.add("username",
                new ActionError("error.username.required"));

        if ((password == null) || (password.length() < 1))
            errors.add("password",
                new ActionError("error.password.required"));

        return errors;

    }

} // End LogonForm
