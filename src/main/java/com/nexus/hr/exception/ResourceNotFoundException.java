package com.nexus.hr.exception;

public class ResourceNotFoundException extends HRException {

	private static final long serialVersionUID = 1L;
	
    public ResourceNotFoundException(String message) {
        super(message);
    }
}