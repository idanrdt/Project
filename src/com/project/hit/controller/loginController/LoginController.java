package com.project.hit.controller.loginController;

import java.io.IOException;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.authenticationSystem.InvalidCredentialsException;

public interface LoginController {
	
	/**
	 * verifies that the {@link User} credentials are corresponding the database.
	 * @param username - the user name of the current {@link User}.
	 * @param password - the password of the current {@link User}.
	 * @throws InvalidCredentialsException if the credentials are wrong.
	 * @throws IOException if the file can't open.
	 * @throws ClassNotFoundException if the object does not exist.
	 */
	public void authenticate(String username, char[] password) throws InvalidCredentialsException, ClassNotFoundException, IOException;
}
