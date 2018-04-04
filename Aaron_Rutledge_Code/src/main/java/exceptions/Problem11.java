package exceptions;

public class Problem11 {
	
	public static void youJustDividedByZero() throws Problem10 {
		
		throw new Problem10();
		
	}
	
	public static void main(String[] args) {
		
		try {
			youJustDividedByZero();
		} catch (exceptions.Problem10 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
