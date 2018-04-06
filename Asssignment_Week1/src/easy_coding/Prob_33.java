package easy_coding;
//Kevin Rivera - Revature
//Assignment Week 1: Easy Coding Exercises - Problem 33.
//This class prints if a variable is odd or even.

public class Prob_33 {
	public static void main(String[] args) {
		int number = 49;
		checkOddEven(number);
		number = 50;
		checkOddEven(number);
	}

	public static void checkOddEven(int num) {
		if (num % 2 == 1)
			System.out.println("Odd");
		else
			System.out.println("Even");
	}
}
