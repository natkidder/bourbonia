package com.jamesholmes.minihr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.struts.action.*;

import com.jamesholmes.minihr.security.User;

public class CustomRequestProcessor extends RequestProcessor {
	protected boolean processRoles(HttpServletRequest request,
																 HttpServletResponse response,
																 ActionMapping mapping)
			throws IOException, ServletException {

			// Is this action protected by role requirements?
			String roles[] = mapping.getRoleNames();
			if ((roles == null) || (roles.length < 1)) {
					return (true);
			}

			// Check the current user against the list of required roles
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			if (user == null) {
				return false;
			}

			for (int i = 0; i < roles.length; i++) {
					if (user.hasRole(roles[i])) {
							return (true);
					}
			}

			response.sendError(HttpServletResponse.SC_BAD_REQUEST,
												 getInternal().getMessage("notAuthorized",
																									mapping.getPath()));
			return (false);

	}
}
