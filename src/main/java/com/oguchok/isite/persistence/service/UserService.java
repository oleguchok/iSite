package com.oguchok.isite.persistence.service;

import com.oguchok.isite.persistence.model.User;
import com.oguchok.isite.validation.exception.EmailExistsException;

public interface UserService {

	User registerNewUserAccount(UserDTO accountDto) throws EmailExistsException;
	
	User findUserByEmail(String email) throws EmailExistsException;
}
