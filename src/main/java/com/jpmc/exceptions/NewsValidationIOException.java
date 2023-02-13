package com.jpmc.exceptions;

public class NewsValidationIOException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2938424669178990458L;

	public NewsValidationIOException(String message) {
		super(message);
	}

	public NewsValidationIOException(Exception e) {
		super(e);
	}

	public NewsValidationIOException(String message, Exception e) {
		super(message, e);
	}
}
