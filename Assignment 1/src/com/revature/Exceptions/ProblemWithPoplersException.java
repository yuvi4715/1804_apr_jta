package com.revature.Exceptions;

public class ProblemWithPoplersException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1868509088225117623L;
	
	public String getMessage() {
		return "Pop a popler in your mouth";
	}
}
