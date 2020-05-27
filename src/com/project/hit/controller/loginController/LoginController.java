package com.project.hit.controller.loginController;

import com.project.hit.fileManager.FileNotFoundException;
import com.project.hit.model.InvalidCredentialsException;

public interface LoginController {
	
	/**
	 * Check if the user details are correct.
	 * @param username - the user name of the current user.
	 * @param password - the password of the current user.
	 * @throws InvalidCredentialsException if the user details is wrong.
	 * @throws FileNotFoundException 
	 */
	public void authenticate(String username, char[] password) throws InvalidCredentialsException, FileNotFoundException;
}
