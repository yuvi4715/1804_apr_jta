package advancedCodingExcercises;
// problem 41 prints out numbers, if they are multiples 3, then prints Fizz, if multiple of 5, Buzz. If both ,FIZZBUZZ - otherwise just integer
public class FizzBuz {
	int[] a = new int[51];
	public FizzBuz() {
		placeNumbers();
		checkAndPlace();
	}

	void placeNumbers() {
		for (int i = 1 ; i < 51; i++) {
			a[i] = i;
		}
		
		
	}
	
	void checkAndPlace() {
		for(int i = 1; i < 51; i++) {
			if((a[i] % 3 == 0) & (a[i] % 5 == 0)) {
				System.out.println("FIZZBUZZ");
			}else if(a[i] % 3 == 0) {
				System.out.println("FIZZ");
			}else if(a[i] % 5 == 0) {
				System.out.println("BUZZ");
			}else {
				System.out.println(a[i]);
			}
		}
	}
		
	
	
	public static void main(String[] args) {
		FizzBuz t = new FizzBuz();
	}
	
}
