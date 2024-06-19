package com.jamesholmes.minihr.security;

import java.util.HashMap;
import java.util.Map;

public class SecurityServiceImpl implements SecurityService
{
  private Map users;
  private static final String ADMIN_ROLE = "administrator";
  
	public SecurityServiceImpl() {
		users = new HashMap();
		users.put("bsiggelkow", 
			new User( "bsiggelkow","Bill", "Siggelkow",  "thatsme", 
			               new String[] {ADMIN_ROLE}));		
		users.put("jholmes", 
			new User( "jholmes","James", "Holmes",  "maindude", 
										 new String[] {ADMIN_ROLE}));
		users.put("gburdell", 
			new User( "gburdell","George", "Burdell",  "gotech", 
										 new String[] {ADMIN_ROLE}));
	}

	public User authenticate(String username, String password)
			throws AuthenticationException {
		User user = (User) users.get(username);
		if (user == null) throw new AuthenticationException("Unknown user");
		boolean passwordIsValid = user.passwordMatch(password);
		if (!passwordIsValid) throw new AuthenticationException("Invalid password");
		return user;
	}
}
