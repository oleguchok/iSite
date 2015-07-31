package com.oguchok.isite.persistence.service;

import com.oguchok.isite.persistence.model.User;
import com.oguchok.isite.validation.exception.RegisterParameterExistsException;

public interface UserService {

	User registerNewUserAccount(UserDTO accountDto) throws RegisterParameterExistsException;

}
