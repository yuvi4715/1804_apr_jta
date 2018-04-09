//Create a custom exception class that overrides the getMessage( ) method

package Exceptions;



public class question10 extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "New edited getMessage";
	}
	
}
