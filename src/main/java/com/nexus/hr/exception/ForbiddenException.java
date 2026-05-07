package com.nexus.hr.exception;

public class ForbiddenException extends HRException {

	private static final long serialVersionUID = 1L;
	
    public ForbiddenException(String message) {
        super(message);
    }
}