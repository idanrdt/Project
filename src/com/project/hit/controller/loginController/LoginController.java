package com.project.hit.controller.loginController;

import java.io.IOException;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.InvalidCredentialsException;

public interface LoginController {
	
	/**
	 * This functions verify that the user details are corresponding the database.
	 * @param username - the user name of the current user.
	 * @param password - the password of the current user.
	 * @throws InvalidCredentialsException if the credentials are wrong.
	 * @throws IOException if the file can't open.
	 * @throws ClassNotFoundException if the object does not exist.
	 */
	public void authenticate(String username, char[] password) throws InvalidCredentialsException, ClassNotFoundException, IOException;
}
