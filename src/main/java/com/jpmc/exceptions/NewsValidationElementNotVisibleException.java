package com.jpmc.exceptions;

public class NewsValidationElementNotVisibleException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5099101554258876804L;

	public NewsValidationElementNotVisibleException(String message) {
		super(message);
	}

	public NewsValidationElementNotVisibleException(Exception e) {
		super(e);
	}

	public NewsValidationElementNotVisibleException(String message, Exception e) {
		super(message, e);
	}
}
