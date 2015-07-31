package com.oguchok.isite.validation.exception;

@SuppressWarnings("serial")
public class RegisterParameterExistsException extends Throwable{

	public RegisterParameterExistsException(String message) {
		
		super(message);
	}
}
