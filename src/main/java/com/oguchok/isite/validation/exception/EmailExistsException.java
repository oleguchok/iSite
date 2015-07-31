package com.oguchok.isite.validation.exception;

@SuppressWarnings("serial")
public class EmailExistsException extends Throwable{

	public EmailExistsException(String message) {
		
		super(message);
	}
}
