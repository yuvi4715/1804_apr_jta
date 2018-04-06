package exceptions;
// problem 11, a class that uses the OverridingGetMessage exception class and throws it.


public class ManualException {
	public ManualException() {
		super();
	}
	
	
	public static void main(String[] args) throws OverridingGetMessage{
		String topic = null;
		if (topic == null) {
			throw new OverridingGetMessage();
		}
	}
	
}
