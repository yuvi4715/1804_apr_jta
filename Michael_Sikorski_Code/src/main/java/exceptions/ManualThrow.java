package exceptions;

public class ManualThrow {
	
	public ManualThrow() throws CustomException {
		throw new CustomException();
	}
	
}
