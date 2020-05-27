package com.project.hit.controller.loginController;

import com.project.hit.fileManager.FileNotFoundException;
import com.project.hit.model.InvalidCredentialsException;

public interface LoginController {
	
	/**
	 * This functions verify that the user details are corresponding the database.
	 * @param username - the user name of the current user.
	 * @param password - the password of the current user.
	 * @throws InvalidCredentialsException if the credentials are wrong.
	 * @throws FileNotFoundException if the file not exist in the Database.
	 */
	public void authenticate(String username, char[] password) throws InvalidCredentialsException, FileNotFoundException;
}
