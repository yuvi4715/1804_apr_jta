package exceptions;

public class CustomException extends Exception {
	
	@Override
	public String getMessage() {
		return "This is a custom message in a custom exception class";
	}

}
