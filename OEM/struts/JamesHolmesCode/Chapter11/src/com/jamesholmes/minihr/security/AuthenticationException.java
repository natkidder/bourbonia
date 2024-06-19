package com.jamesholmes.minihr.security;

public class AuthenticationException extends Exception {
	
	public AuthenticationException() {
		super();
	}
	public AuthenticationException(String msg) {
		super(msg);
	}
	public AuthenticationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
