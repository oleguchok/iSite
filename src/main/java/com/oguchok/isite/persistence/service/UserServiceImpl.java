package com.oguchok.isite.persistence.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oguchok.isite.persistence.model.User;
import com.oguchok.isite.persistence.repository.RoleRepository;
import com.oguchok.isite.persistence.repository.UserRepository;
import com.oguchok.isite.validation.exception.EmailExistsException;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public User registerNewUserAccount(UserDTO accountDto) throws EmailExistsException{
		
		if (emailExist(accountDto.getEmail())) {
			throw new EmailExistsException("There is an account with that email address:" +
					accountDto.getEmail());
		}
		
		return userRepository.save(getUserObjectFromUserDto(accountDto));
	}

	private User getUserObjectFromUserDto(UserDTO userDto) {
		
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
		return user;
	}
	
	private boolean emailExist(String email) {
		
		User user = userRepository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
	
}
