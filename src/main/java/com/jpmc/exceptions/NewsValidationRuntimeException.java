package com.jpmc.exceptions;

public class NewsValidationRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6057945903284815260L;

	public NewsValidationRuntimeException(String message) {
		super(message);
	}

	public NewsValidationRuntimeException(Exception e) {
		super(e);
	}

	public NewsValidationRuntimeException(String message, Exception e) {
		super(message, e);
	}
}
