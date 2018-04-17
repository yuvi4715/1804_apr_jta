package com.revature.exceptions;

public class NonEmptyAccountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6335517655585925379L;

	public String getMessage() {
		return "The account that is to be deleted is not empty";
	}
}
