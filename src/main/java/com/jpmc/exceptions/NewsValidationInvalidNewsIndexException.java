package com.jpmc.exceptions;

public class NewsValidationInvalidNewsIndexException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8057246228049344244L;

	public NewsValidationInvalidNewsIndexException(String message) {
		super(message);
	}

	public NewsValidationInvalidNewsIndexException(Exception e) {
		super(e);
	}

	public NewsValidationInvalidNewsIndexException(String message, Exception e) {
		super(message, e);
	}
}
