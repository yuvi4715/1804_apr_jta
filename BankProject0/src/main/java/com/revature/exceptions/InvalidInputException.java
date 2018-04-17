package com.revature.exceptions;

public class InvalidInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8728478339198993097L;
	
	public String getMessage() {
		return "The entry must be one of displayed values";
	}
}
