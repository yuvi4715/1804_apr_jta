package com.revature.exceptions;

// Question 10
public class NonMarvelCharacterException extends Exception {
	public String getMessage() {
		return "=====>> Caught Exception NonMarvelCharacterException: Not a Marvel Character";
	}
}
