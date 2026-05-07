package com.nexus.hr.exception;

public class BadRequestException extends HRException {
	
	private static final long serialVersionUID = 1L;

	public BadRequestException(String message) {
		super(message);
	}
}