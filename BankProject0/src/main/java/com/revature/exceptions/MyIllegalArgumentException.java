package com.revature.exceptions;

public class MyIllegalArgumentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7590915934440375910L;
	
	
	public String getMessage() {
		return "A deposit or inital value of an account balance cannot place the account in the negative";
	}
	
}
