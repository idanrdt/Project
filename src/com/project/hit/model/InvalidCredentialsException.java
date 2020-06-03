package com.project.hit.model;

/**
 * Signals that the credentials specified are wrong.
 */
public class InvalidCredentialsException extends Exception {
	
	private String msg;
	
	public InvalidCredentialsException(CredentialType type) {
		switch(type) {
		case EMPTY:
			msg = "Username or Password Can not be empty!";
			break;
		case USERNAME:
			msg = "Invalid Username!";
			break;
		case PASSWORD:
			msg = "Invalid Password";
			break;
		default:
			msg = "Unknown error occurd";
		}
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
