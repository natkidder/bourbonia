package com.jamesholmes.minihr;

import javax.servlet.http.*;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.*;

import com.jamesholmes.minihr.security.*;

public final class LoginAction extends Action
{
  public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception
  {
		HttpSession session = request.getSession();

		String username = (String) PropertyUtils.getSimpleProperty(form, "username");
		String password = (String) PropertyUtils.getSimpleProperty(form, "password");

    SecurityService service = new SecurityServiceImpl();
    User user = service.authenticate(username, password);
    session.setAttribute("user", user);
    
    // store a cookie
	  /*
		Cookie usernameCookie = new Cookie("MiniHRUsername", username);
		usernameCookie.setMaxAge(60 * 60 * 24 * 30); // 30 day expiration
		response.addCookie(usernameCookie);
		Cookie passwordCookie = new Cookie("MiniHRPassword", password);
		passwordCookie.setMaxAge(60 * 60 * 24 * 30); // 30 day expiration
		response.addCookie(passwordCookie);
    */
    return mapping.findForward("success");
  }
}
