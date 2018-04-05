package advancedCodingExercises;

public class Problem45 {
	
	public static void main(String[] args) {
		
		boolean temp = false;
		
		for (int i = 0; i < 1000; i++) {
			
			temp = checkPrime(i);
			
			if(temp) {
				System.out.println(i);
			}
			
			
			
		}
			
		
		
		
		
	}
	
	
	public static boolean checkPrime(int num) {
		
		if (num <= 1) {
			return false;
		}
		
		
		for (int i = 2; i < num; i++) {
			
			if(num%i == 0) {
				
				return false;
			}
			
		}
		
		return true;
		
		
	}
	
	

}
