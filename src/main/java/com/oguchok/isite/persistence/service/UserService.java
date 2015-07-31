package com.oguchok.isite.persistence.service;

import com.oguchok.isite.persistence.model.User;

public interface UserService {

	User registerNewUserAccount(UserDTO accountDto);
	
	User findUserByEmail(String email);
}
