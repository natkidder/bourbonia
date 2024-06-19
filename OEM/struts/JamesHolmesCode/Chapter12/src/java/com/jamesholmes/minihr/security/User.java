package com.jamesholmes.minihr.security;

import java.io.Serializable;

public class User implements Serializable {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String[] roles;

	public User() {
	}

	public User(String name, String fName, String lName, String pwd, String[] assignedRoles) {
		username  = name;
		firstName = fName;
		lastName  = lName;
		password  = pwd;
		roles = assignedRoles;
	}

  public String getUsername() {
    return username;
  }

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	boolean passwordMatch(String pwd) {
		return password.equals(pwd);
	}

	public boolean hasRole(String role) {
		if (roles.length > 0) {
			for (int i=0; i<roles.length; i++) {
				if (role.equals(roles[i])) return true;
			}
		}
		return false;		
	}

	public boolean isAdministrator() {
		return hasRole("administrator");
	}
}
