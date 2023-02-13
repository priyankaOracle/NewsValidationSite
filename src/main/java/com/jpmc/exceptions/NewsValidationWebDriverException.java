package com.jpmc.exceptions;

public class NewsValidationWebDriverException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3913794193688794064L;

	public NewsValidationWebDriverException(String message) {
		super(message);
	}

	public NewsValidationWebDriverException(Exception e) {
		super(e);
	}

	public NewsValidationWebDriverException(String message, Exception e) {
		super(message, e);
	}
}
