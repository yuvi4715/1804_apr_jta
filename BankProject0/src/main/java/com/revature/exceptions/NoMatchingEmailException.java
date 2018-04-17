package com.revature.exceptions;

public class NoMatchingEmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1129190895431015873L;

	public String getMessage() {
		return "No matching email addresses in the database";
	}
}
