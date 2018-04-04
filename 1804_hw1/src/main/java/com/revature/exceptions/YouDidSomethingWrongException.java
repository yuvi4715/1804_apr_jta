package com.revature.exceptions;

public class YouDidSomethingWrongException extends Exception{

	private static final long serialVersionUID = 4170044702314534004L;

	public String getMessage() {
		return "Oops! Looks like you did something wrong!";
	}
}
