package advancedCodingExcercises;

import java.util.Scanner;

//problem 45 determine if a number is prime
public class PrimeNumber {
	int input;
	
	
	public PrimeNumber() {
		System.out.println("Enter a number greater than 2");
		getInput();
		if (isPrime(input)) {
			System.out.println("The number entered is prime");
		}
		else {
			System.out.println("The number entered is not prime");
		}
	}
	
	void getInput() {
		Scanner k = new Scanner(System.in);
		input = k.nextInt();
		k.close();
		
	}
	
	boolean isPrime(int input) {
		boolean isPrime = false;
		for(int i = 2; 2*i < input;i++) { // tried to be efficient here.
			if(input % i ==0) {  // use of mod is pretty import, so I went with it
				isPrime = false;
		    }
		    isPrime =  true;
		}
		return isPrime;
	}
	
	public static void main(String[] args) {
		PrimeNumber t = new PrimeNumber();
	}
}
