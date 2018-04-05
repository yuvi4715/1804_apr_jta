package advancedCodingExercises;

public class Problem40 {
	
	
	public static void main(String[] args) {
		
		//Problem40.iterateFibonacci();
		Problem40.recursiveFibonacci(1, 1, 100);
		
		
		
	}
	
	
	public static void iterateFibonacci() {
		
		long prev = 1;
		long num = 1;
		long temp = 0;
		
		for (int i = 2; i <= 100; i++) {
			
			temp = num;
			num = prev + num;
			prev = temp;
			
			System.out.println(num);
			
		}
		
		
		
	}
	
	public static long recursiveFibonacci(long num1, long num2, int seqPosition) {
		
		long temp = num1 + num2;
		
		System.out.println(temp);
		if(seqPosition > 2) {
			return recursiveFibonacci(num2, temp, (seqPosition-1));
		} else {
			
			return temp;
			
		}
		
		
		
		
	}

}
