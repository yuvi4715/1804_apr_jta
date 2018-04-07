package exceptions_java;
import java.lang.Exception;

/**
 * 
 * @author kathe
 *
 *	Custom exception class
 */
public class exception extends Exception {
	
	String message;
	exception(String messages)
	{
		super(messages);
		this.message = messages;
		
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
