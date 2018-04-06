package easyCodingExcersizes;
//33 - write a method to determine if a number is even or odd and print out result
import java.util.Scanner;

public class CheckOddEven {
	static void check() {
		System.out.println("Enter a number");
		Scanner k = new Scanner(System.in);
		
		int number;
		
		number = k.nextInt();
		if (number % 2 ==0 ) {
			System.out.println("Even Number");
			
		} else {
			System.out.println("Odd Number");
		}
		k.close();
	}
	
	public static void main(String[] args) {
		check();
	}
}
