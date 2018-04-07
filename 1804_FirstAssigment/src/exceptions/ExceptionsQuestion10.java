package exceptions;

public class ExceptionsQuestion10 extends Exception {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	Create a custom exception class that overrides the getMessage( ) method

	
	public String getMessage() {
		System.out.println("Message overriden.");
		return "Message overriden.";
		
	}

}	