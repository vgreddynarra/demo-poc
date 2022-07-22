package com.sanelahealth.poc.exception;

import org.springframework.http.HttpStatus;

/*
 * Base exception class used to indicate an error while executing a service api.
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/** HTTP error code */
	HttpStatus httpStatus;

	public ServiceException(HttpStatus status) {
		httpStatus = status;
	}

	public ServiceException(HttpStatus status, String message) {
		super(message);
		httpStatus = status;
	}

	public ServiceException(HttpStatus status, String message, Throwable cause) {
		super(message, cause);
		httpStatus = status;
	}

	public ServiceException(HttpStatus status, Throwable cause) {
		super(cause);
		httpStatus = status;
	}

	/*
	 * Return error code.
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
