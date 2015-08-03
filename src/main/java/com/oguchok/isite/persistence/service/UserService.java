package com.oguchok.isite.persistence.service;

import com.oguchok.isite.persistence.model.User;
import com.oguchok.isite.persistence.model.VerificationToken;
import com.oguchok.isite.validation.exception.RegisterParameterExistsException;

public interface UserService {

	User registerNewUserAccount(UserDTO accountDto) throws RegisterParameterExistsException;
	
	User getUser(String verificationToken);
	 
	void saveRegisteredUser(User user);
	 
	void createVerificationToken(User user, String token);
	 
	VerificationToken getVerificationToken(String VerificationToken);

}
