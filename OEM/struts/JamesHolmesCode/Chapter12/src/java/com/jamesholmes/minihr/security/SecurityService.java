package com.jamesholmes.minihr.security;

public interface SecurityService {

	public User authenticate(String username, String password)
		throws AuthenticationException;
}
