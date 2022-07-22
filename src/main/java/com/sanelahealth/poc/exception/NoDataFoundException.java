package com.sanelahealth.poc.exception;

import org.springframework.http.HttpStatus;

public class NoDataFoundException extends ServiceException {
	private static final long serialVersionUID = 1L;
	private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

	public NoDataFoundException(String message) {
		super(HTTP_STATUS, message);
	}

	public NoDataFoundException(String message, Throwable cause) {
		super(HTTP_STATUS, message, cause);
	}

	public NoDataFoundException(Throwable cause) {
		super(HTTP_STATUS, cause);
	}
}
