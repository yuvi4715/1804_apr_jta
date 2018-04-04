package exceptions;
//Kevin Rivera - Revature
//Assignment Week 1: OOP - Problem 10.
//This a custom Exception class that overrides the getMessage() method.

public class MyException extends Exception {
	@Override
	public String getMessage() {
		return "I got you, son.";
	}
}
