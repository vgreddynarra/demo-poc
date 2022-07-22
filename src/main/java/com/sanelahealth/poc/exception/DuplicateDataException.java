package com.sanelahealth.poc.exception;

import org.springframework.http.HttpStatus;

public class DuplicateDataException extends ServiceException {
	private static final long serialVersionUID = 1L;
	private static final HttpStatus HTTP_STATUS = HttpStatus.CONFLICT;

	public DuplicateDataException(String message) {
		super(HTTP_STATUS, message);
	}

	public DuplicateDataException(String message, Throwable cause) {
		super(HTTP_STATUS, message, cause);
	}

	public DuplicateDataException(Throwable cause) {
		super(HTTP_STATUS, cause);
	}
}
