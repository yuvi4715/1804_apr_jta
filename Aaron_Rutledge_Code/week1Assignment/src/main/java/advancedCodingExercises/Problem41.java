package advancedCodingExercises;

public class Problem41 {
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= 50; i++)
		{
			if((i % 3) == 0 && (i % 5) ==0 ) {
				System.out.println("fizzbuzz");
			} else if ((i % 3) == 0) {
				System.out.println("fizz");
			} else if ((i % 5) == 0) {
				System.out.println("buzz");				
			} else {
				System.out.println(i);
			}
			
		}
		
		
	}
	
	
	
	
	
	
	
	
}
