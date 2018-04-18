package exceptions;

public class Problem13 {
	
	public static void main(String[] args) {
		
		System.out.println("In main, we'll try and catch a function that ducks an exception for us.");
		
		try {
			
			duckException();
		} catch (Problem10 e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	public static void duckException() throws Problem10 {
		
		Problem11.youJustDividedByZero();
	}
	
	

}
