package com.beosbank.jbdevg.jbossas.jaas;

import java.security.acl.Group;
import java.util.Base64;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

import org.jboss.security.auth.spi.DatabaseServerLoginModule;

public class BeosBankLoginModule extends DatabaseServerLoginModule{

	private static final String $_CRYPT = "${CRYPT}";

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		super.initialize(subject, callbackHandler, sharedState, options);
	}

	@Override
	protected String getUsersPassword() throws LoginException {
		
		return super.getUsersPassword();
	}

	@Override
	protected Group[] getRoleSets() throws LoginException {
		return super.getRoleSets();
	}
	
	/**
	 * Some BeosBank Passwords are now store with the format ${CRYPT}Base64Text${CRYPT}format
	 */
	@Override
	protected String convertRawPassword(String rawPassword) {
		String plainPassword = null;
		System.out.println("======>Password "+rawPassword+" retreived for user "+getUsername());
		if(rawPassword.startsWith($_CRYPT) && rawPassword.endsWith($_CRYPT)){
			String rawPwdEncryptedValue = rawPassword.substring($_CRYPT.length(), rawPassword.length()-$_CRYPT.length());
			plainPassword= new String(Base64.getDecoder().decode(rawPwdEncryptedValue.getBytes()));
		}
		else{
			plainPassword=rawPassword;
		}
		System.out.println("======>Decoded Password "+plainPassword+"  for user "+getUsername());

		return plainPassword;
	}
	

}
