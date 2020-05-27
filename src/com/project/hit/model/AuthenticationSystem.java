package com.project.hit.model;

import com.project.hit.fileManager.*;

//import java.util.Set;

public class AuthenticationSystem {
	
	//private Set<User> userSet;
	private FileManger files;
	
	public AuthenticationSystem() {
		files = new FileManger();
	}
	
	/**
	 * Check if the User details corresponding the Database.
	 * @param userName - The user name.
	 * @param password - The user password.
	 * @return - True if authentication succeeded.
	 * @throws InvalidCredentialsException if any detail is wrong or empty.
	 */
	public Boolean authenticate(String userName, char[] password) throws InvalidCredentialsException, FileNotFoundException {
		if(userName.isEmpty() || password.length == 0) {
			throw new InvalidCredentialsException(CredentialType.EMPTY);
		}
		 /* userSet = files.loadFromFile(FileNameSelect.USERFILE);
		 * for(User user : userSet){
		 *  	if(user.getUsername().equals(userName)) {
		 *  		if(Arrays.equals(user.getPassword(),password) {
		 *  			return true;
		 *  		}
		 *  		else {
		 *  			throw new InvalidCredentialsException(CredentialType.Password);
		 *  		}
		 *  	}
		 *  }
		 *  
		 *  throw new InvalidCredentialsException(CredentialType.UserName);
		 * 
		 * TODO:
		 * 2. Implement User.
		 * 3. Remove Comments.
		 * 
		 * */
		return true;
	}
	
	//Option B - return User object
	/*	public User authenticate(String userName, char[] password) throws InvalidCredentialsException, FileNotFoundException {
		if(userName.isEmpty() || password.length == 0) {
			throw new InvalidCredentialsException(CredentialType.EMPTY);
		}
		 /* userSet = files.loadFromFile(FileNameSelect.USERFILE);
		 * for(User user : userSet){
		 *  	if(user.getUsername().equals(userName)) {
		 *  		if(Arrays.equals(user.getPassword(),password) {
		 *  			return user;
		 *  		}
		 *  		else {
		 *  			throw new InvalidCredentialsException(CredentialType.Password);
		 *  		}
		 *  	}
		 *  }
		 *  
		 *  throw new InvalidCredentialsException(CredentialType.UserName);
		 *  */
}
