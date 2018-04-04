package com.revature.exceptions;

// Solution to hw1 problem #10

public class YouDidSomethingWrongException extends Exception{

	private static final long serialVersionUID = 4170044702314534004L;

	public String getMessage() {
		return "Oops! Looks like you did something wrong!";
	}
}
