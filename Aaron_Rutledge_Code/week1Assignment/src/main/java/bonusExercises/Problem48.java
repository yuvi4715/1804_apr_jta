package bonusExercises;

public class Problem48 {
	
	
	public static void main(String[] args) {
		
		System.out.println(computeFactorial(10));
		
		
		
	}
	
	
	
	public static long computeFactorial(long x) {
		
		
		
		for (long i = x-1; i > 1; i=i-1) {
			
			x = x * i;
			System.out.println(x);
			
		}
		
		
		
		
		
		
		return x;
		
	}

}
