package com.revature.projzeroQtn10To15;



//	Create a custom exception class that overrides the getMessage( ) method
//	Create a class that manually throws an exception of your custom type
//	Use System.out.println( ) to note where you are in the control flow. Example: “Starting try block”, “Ending try block”, “Starting catch block”, etc.
//	Duck the exception at least once
//	Implement a finally block that prints a graceful goodbye message
//	Use the System.exit(0) command in the try block and rerun the application. Note the console output to see if the finally block executes.

	//CustomDivideByZero.java
	public class CustomDivideByZero extends Exception{
	   /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	//constructor
	   public CustomDivideByZero(String msg) {
	       super(msg);
	   }
	   //Override the getMessage method
	   public String getMessage() {
	       return super.getMessage();
	   }
}
