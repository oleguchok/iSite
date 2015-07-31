package com.oguchok.isite.persistence.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguchok.isite.persistence.model.User;
import com.oguchok.isite.persistence.repository.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User registerNewUserAccount(UserDTO accountDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
