package exceptions;

public class TryAndCatch10 {

	public static void testMethod() {
		
		try {
			
			throw new ExceptionsQuestion10();
			
			
		}
		
		catch (ExceptionsQuestion10 x) {
			x.getMessage();
			System.out.println(x.getMessage());
		
		}
		
	
	}
	
	public static void main(String[] args) {
		
		testMethod();
			
		}
		
	}
	

