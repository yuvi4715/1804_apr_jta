package dev;

public class InvalidInputException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3368672660706795024L;
	
	public InvalidInputException() {}
	
	public InvalidInputException(String msg)
	{
		Log.userError(msg);
		System.out.println("Please enter a valid input");
	}
	

}
