package com.nexus.hr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// COMMON RESPONSE STRUCTURE
	public static class ErrorResponse {
		private String message;
		private LocalDateTime timestamp;

		public ErrorResponse(String message) {
			this.message = message;
			this.timestamp = LocalDateTime.now();
		}

		public String getMessage() {
			return message;
		}

		public LocalDateTime getTimestamp() {
			return timestamp;
		}
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
		return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex) {
		return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ErrorResponse> handleDuplicate(DuplicateResourceException ex) {
		return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {
		return new ResponseEntity<>(new ErrorResponse("Something went wrong: " + ex.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}