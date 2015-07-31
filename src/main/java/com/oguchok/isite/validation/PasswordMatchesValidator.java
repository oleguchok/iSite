package com.oguchok.isite.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.oguchok.isite.persistence.service.UserDTO;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches arg0) {
		
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		
		UserDTO user = (UserDTO) obj;
		return user.getPassword().equals(user.getMathcingPassword());
	}
	
}
