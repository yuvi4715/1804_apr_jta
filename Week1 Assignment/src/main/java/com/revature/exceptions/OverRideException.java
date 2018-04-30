package com.revature.exceptions;

public class OverRideException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 10. Create a custom exception class that overrides the getMessage( ) method
	 */
	public String getMessage() {
		return "Hello";
	}
}
