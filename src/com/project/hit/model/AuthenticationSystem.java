package com.project.hit.model;

public class AuthenticationSystem {
	
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
