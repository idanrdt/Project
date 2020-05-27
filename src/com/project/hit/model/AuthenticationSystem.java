package com.project.hit.model;

import com.project.hit.details.User;
import com.project.hit.fileManager.*;
import java.util.Set;

public class AuthenticationSystem {
	
	private Set<User> userSet;
	private FileManger<User> files;
	
	/**
	 * The {@link AuthenticationSystem} Constructor.
	 */
	public AuthenticationSystem() {
		files = new FileManger<>();
	}

	/**
	 * This functions verify that the user details are corresponding the database.
	 * @param userName - the user UserName.
	 * @param password - the user Password.
	 * @return the {@link User} object if the authentication succeeded.
	 * @throws InvalidCredentialsException If the credentials are wrong.
	 * @throws FileNotFoundException if the file not exist in the Database.
	 */
	public User authenticate(String userName, char[] password) throws InvalidCredentialsException, FileNotFoundException {
		if(userName.isEmpty() || password.length == 0) {
			throw new InvalidCredentialsException(CredentialType.EMPTY);
		}
		userSet = files.loadFromFile(FileNameSelect.USERFILE);
		for(User user : userSet) {
			if(user.getUserName().equals(userName)) {
				if(user.getpassword().equals(String.valueOf(password))) {
					return user;
				}
				else {
					throw new InvalidCredentialsException(CredentialType.PASSWORD);
				}
			}
		}
		throw new InvalidCredentialsException(CredentialType.USERNAME);
	}
}
