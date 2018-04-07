package assignment.Joey.EasyCodingProgram;
/**
 * 2. Write a program called CheckOddEven which prints "Odd Number" 
 * if the int variable “number” is odd, or “Even Number” otherwise. 
 * Hint: you may use modulus operator.
 */


public class CheckOddEven {
	public static void main(String[] args) {
		int number =0;
		if (number ==0) System.out.println("Is Zero");
		else if(number%2 ==0) System.out.println("Even Number");
		else System.out.println("Odd Number");
	}

}
