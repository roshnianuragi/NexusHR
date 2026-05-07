package com.nexus.hr.exception;

public class HRException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HRException(String message) {
        super(message);
    }
}