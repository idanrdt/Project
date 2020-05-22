package authentication;

public class AuthenticationSystem {
	
	public Boolean authenticate(String userName, char[] password) throws InvalidCredentialsException {
		if(userName.isEmpty() || password.length == 0) {
			throw new InvalidCredentialsException(CredentialType.EMPTY);
		}
		return true;
	}

}
