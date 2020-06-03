package com.project.hit.model;

import com.project.hit.details.User;
import com.project.hit.fileManager.*;

import java.io.IOException;
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
	 * @throws IOException if the file can't open.
	 * @throws ClassNotFoundException if the object does not exist.
	 */
	public User authenticate(String userName, char[] password) throws InvalidCredentialsException, ClassNotFoundException, IOException {
		if(userName.isEmpty() || password.length == 0) {
			throw new InvalidCredentialsException(CredentialType.EMPTY);
		}
		try {
			userSet = files.loadFromFile(FileNameSelect.USERFILE);
		}
		catch(EnumNameNotFoundException enf) {
			System.out.println("Enum selection is wrong");
		}
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
