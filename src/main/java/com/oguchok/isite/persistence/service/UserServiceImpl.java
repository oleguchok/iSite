package com.oguchok.isite.persistence.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oguchok.isite.persistence.model.User;
import com.oguchok.isite.persistence.model.VerificationToken;
import com.oguchok.isite.persistence.repository.RoleRepository;
import com.oguchok.isite.persistence.repository.UserRepository;
import com.oguchok.isite.persistence.repository.VerificationTokenRepository;
import com.oguchok.isite.validation.exception.RegisterParameterExistsException;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private VerificationTokenRepository tokenRepository;
	
	@Transactional
	@Override
	public User registerNewUserAccount(UserDTO accountDto) throws RegisterParameterExistsException{
		
		checkParametersForRegister(accountDto.getUsername(), accountDto.getEmail());
		
		return userRepository.save(getUserObjectFromUserDto(accountDto));
	}

	private void checkParametersForRegister(String username, String email) throws RegisterParameterExistsException {
		if (usernameExist(username)) {
			throw new RegisterParameterExistsException("There is an account with that username: " +
					username);
		}
		if (emailExist(email)) {
			throw new RegisterParameterExistsException("There is an account with that email address:" +
					email);
		}
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
	
	private boolean usernameExist(String username) {
		
		User user = userRepository.findByUsername(username);
		if (user != null) {
			return true;
		}
		return false;
	}

	@Override
    public User getUser(String verificationToken) {
        User user = tokenRepository.findByToken(verificationToken).getUser();
        return user;
    }
     
    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }
     
    @Override
    public void saveRegisteredUser(User user) {
        userRepository.save(user);
    }
     
    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }

	@Override
	public User getUserByName(String username) {
		
		return userRepository.findByUsername(username);
	}
}
