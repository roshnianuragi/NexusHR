package com.nexus.hr.exception;

public class UnauthorizedException extends HRException {

	private static final long serialVersionUID = 1L;

	public UnauthorizedException(String message) {
		super(message);
	}
}