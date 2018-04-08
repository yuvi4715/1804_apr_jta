package com.revature.hello;

// 10
// Create a custom exception class that overrides the getMessage( ) method
class NewException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		// 12 Use System.out.println( ) to note where you are in the control flow.
		// Example:

		// “Starting try block”, “Ending try block”, “Starting catch block”, etc.
		// Duck the exception at least once
		// Implement a finally block that prints a graceful goodbye message
		// Use the System.exit(0) command in the try block and rerun the application.
		// Note the console output to see if the finally block executes.

		// System.out.println("Called from the inner clas Foo" + new Foo().baz());
		NewException ne = new NewException();

		try {
			System.out.println("Starting try block...");
			ne.bar();
			System.exit(0);
			System.out.println("Ending try block.");

		} catch (Exception e) {
			System.out.println("Starting catch block...");

			System.out.println("Ending catch block.");
		} finally {
			System.out.println("graceful message");
		}
	}

	public String getMessage() {
		return "newException";
	}

	// 11 Create a class that manually throws an exception of your custom type

	public void bar() throws NewException {	// ducks
		throw new NewException();
	}
}