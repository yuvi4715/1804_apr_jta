package com.revature.exceptions;

public class UserHasNotBeenValidatedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6163896389695287758L;

	public String getMessage() {
		return "The user has not been validated yet.";
	}
}
