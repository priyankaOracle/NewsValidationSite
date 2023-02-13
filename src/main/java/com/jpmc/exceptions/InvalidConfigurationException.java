package com.jpmc.exceptions;

public class InvalidConfigurationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4977231361051475444L;

	public InvalidConfigurationException(String message) {
		super(message);
	}

	public InvalidConfigurationException(Exception e) {
		super(e);
	}

	public InvalidConfigurationException(String message, Exception e) {
		super(message, e);
	}
}
