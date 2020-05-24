package com.project.hit.model;

public class AuthenticationSystem {
	
	/**
	 * Check if the User details corresponding the Database.
	 * @param userName - The user name.
	 * @param password - The user password.
	 * @return - True if authentication succeeded.
	 * @throws InvalidCredentialsException if any detail is wrong or empty.
	 */
	public Boolean authenticate(String userName, char[] password) throws InvalidCredentialsException {
		if(userName.isEmpty() || password.length == 0) {
			throw new InvalidCredentialsException(CredentialType.EMPTY);
		}
		/* FileManager files = new FileManager();
		 * UserArry currentUser = fileManager.getUser(userName);
		 * 
		 * 
		 * 
		 * */
		return true;
	}

}
