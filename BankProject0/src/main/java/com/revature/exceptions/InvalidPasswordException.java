package com.revature.exceptions;

public class InvalidPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5754261567514472067L;
	
	public String getMessage() {
		return "Incorrect password";
	}
}
