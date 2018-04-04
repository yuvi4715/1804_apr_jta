package exceptions;

public class Problem12 {
	
	public static void main(String[] args) {
		
		try {
			
			System.out.println("Starting try block.");
			
			Problem11.youJustDividedByZero();
			
			System.out.println("Ending try block. This won't print.");
			
		} catch(Problem10 e1 ) {
			
			System.out.println("Starting specific catch block.");
			System.out.println(e1.getMessage());
			System.out.println("Ending specific case catch block.");
			
		} catch(Exception e2) {
			
			System.out.println("Starting general case catch block.");
			System.out.println("This block shouldn't print");
			System.out.println("Ending general case catch block.");
			
		} finally {
			System.out.println("Starting finally block. This executes regardless.");
			
			System.out.println("Ending finally block.");
		}
	}
	
	

}
