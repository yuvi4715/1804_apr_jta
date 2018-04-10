package com.revature.exceptions;

//problems 10-15
public class CustomException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		System.out.println("entered custom getMessage");
		return "MISTAKES WERE MADE";
	}
	
	
	
	
}
