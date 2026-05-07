package com.nexus.hr.exception;

public class DuplicateResourceException extends HRException {

	private static final long serialVersionUID = 1L;

	public DuplicateResourceException(String message) {
		super(message);
	}
}