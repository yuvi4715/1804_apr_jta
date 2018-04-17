package com.revature.exceptions;

public class OverDrawnException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9032098262408446267L;
	
	public String getMessage() {
		return "this amount of money would overdraw your account";
	}
}
