package exceptions;
//Kevin Rivera - Revature
//Assignment Week 1: OOP - Problem 11, 12, 13, 14, 15.
//This a class to manually throw an exception of type MyException.

public class Throw_MyException {
	public static void main(String[] args) throws MyException {
		testingTryCatch();
		throw new MyException();
	}
	
	public static void testingTryCatch() {
		try {
			System.out.println("Throwing a MyException...");
			throw new MyException();
		} catch (MyException e) {
			System.out.println("Successfully catched MyException");
			System.out.println("But...");
			testingWithFinally();
		}
	}
	
	public static void testingWithFinally() {
		try {
			throw new ArithmeticException();
		} finally {
			System.out.println("I guess this is it...");
			System.exit(0);
		}
	}
}
