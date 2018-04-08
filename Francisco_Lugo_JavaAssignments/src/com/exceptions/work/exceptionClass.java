package com.exceptions.work;

public class exceptionClass extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5083580740693816056L;

	public exceptionClass(String message) {
		super(message);
	}
	
	public void throwMethod() throws Exception {
		System.out.println("This is a thrown exception message");
	}
	
}
