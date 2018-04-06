package com.revature.exceptions;

public class ManualThrows {
	/*
	 * 11.	Create a class that manually throws an exception of your custom type.
	   12.	Use System.out.println( ) to note where you are in the control flow. Example: “Starting try block”, “Ending try block”, “Starting catch block”, etc.
	   13.	Duck the exception at least once
	   14.	Implement a finally block that prints a graceful goodbye message
	   15.	Use the System.exit(0) command in the try block and rerun the application. Note the console output to see if the finally block executes.
	 */
	public static void main(String[] args) {
		ManualThrows thrower = new ManualThrows();
		try {
			System.out.println("Starting try block");
			System.exit(0);
			thrower.custom();
			System.out.println("Ending try block");
		} catch (OverRideException e) {
			System.out.println("Starting catch block");
			e.printStackTrace();
			System.out.println("Ending catch block");
		} finally {
			System.out.println("Starting finally block");
			System.out.println("Finally we made it. Goodbye friends.");
			System.out.println("Ending finally block");
		}
	}
	void custom() throws OverRideException {
	} //using throws is ducking the exception
}
