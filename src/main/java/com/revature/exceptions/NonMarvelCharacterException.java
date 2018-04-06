package com.revature.exceptions;

public class NonMarvelCharacterException extends Exception {
	public String getMessage() {
		return "=====>> Caught Exception NonMarvelCharacterException: Not a Marvel Character";
	}
}
