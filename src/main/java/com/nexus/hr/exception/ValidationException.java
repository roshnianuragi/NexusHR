package com.nexus.hr.exception;

public class ValidationException extends HRException {

	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
		super(message);
	}
}