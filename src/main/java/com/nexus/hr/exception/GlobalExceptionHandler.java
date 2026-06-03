package com.nexus.hr.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// COMMON ERROR RESPONSE (IMPROVED STRUCTURE)
	public static class ErrorResponse {

		private boolean success;
		private String message;
		private int status;
		private LocalDateTime timestamp;

		public ErrorResponse(String message, int status) {
			this.success = false;
			this.message = message;
			this.status = status;
			this.timestamp = LocalDateTime.now();
		}

		public boolean isSuccess() {
			return success;
		}

		public String getMessage() {
			return message;
		}

		public int getStatus() {
			return status;
		}

		public LocalDateTime getTimestamp() {
			return timestamp;
		}
	}

	// RESOURCE NOT FOUND
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// BAD REQUEST
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	// DUPLICATE RESOURCE
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ErrorResponse> handleDuplicate(DuplicateResourceException ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value());

		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}

	// VALIDATION ERRORS (IMPROVED FORMAT)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {

		Map<String, String> fieldErrors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			fieldErrors.put(fieldName, message);
		});

		Map<String, Object> response = new HashMap<>();
		response.put("success", false);
		response.put("message", "Validation failed");
		response.put("errors", fieldErrors);
		response.put("status", HttpStatus.BAD_REQUEST.value());
		response.put("timestamp", LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	// RUNTIME EXCEPTION
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRuntime(RuntimeException ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	// GENERAL EXCEPTION
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {

		ErrorResponse error = new ErrorResponse("Something went wrong: " + ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}