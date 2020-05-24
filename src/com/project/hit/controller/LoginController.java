package com.project.hit.controller;

import com.project.hit.model.InvalidCredentialsException;

public interface LoginController {
	
	public void authenticate(String username, char[] password) throws InvalidCredentialsException;
}
