package exceptions;

public class Problem15 {
	
	
	public static void main(String[] args) {
		
		try {
			System.out.println("This prints.");
			
			System.exit(0);
			
			Problem11.youJustDividedByZero();
		} catch (Problem10 e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			System.out.println("Does this print? No.");
		}
		
		
		
		
		
		
	}

}
