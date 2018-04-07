package assignment.Joey.Exceptions;
/**
 * a custom exception class that overrides the getMessage( ) method
 * 
 * @author joeyi
 *
 */
public class Exception1 extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public Exception1(String customerException)
	{
	
		super(customerException);
		message=customerException;
	}
	
	@Override
	public String getMessage() {
		return message;
		
	}
	
	/**@Override
	public String getLocalizedMessage() {
		
	}*/

}
