package advanced_coding;
//Kevin Rivera - Revature
//Assignment Week 1: Advanced Coding: Problem 43.
//This class takes a number and checks if it's an armtrong number

public class Prob_43 {
	public static void main(String[] args) {
		//Temp number to store result
		int result = 0;
		// Number to be examined, save it to temp var
		int number = 153;
		int tempNum = number;
		// Get the number of digits in the number
		int digits = String.valueOf(number).length();
		int counter = digits;
		System.out.println("this number " + number + " has "+ digits + " digits.");
		
		// Array to store each digit
		int[] array = new int[digits];
		// Get each digit in the number and store in array using modulus 10
		while (number > 0) {
			counter--;
			array[counter] = number % 10;
			number = (int) Math.floor(number / 10);
		}
		//Raise and sum each number in the array to the power of "digits"
		System.out.println();
		for (int i = 0; i < digits; i++) {
			result += Math.pow(array[i], digits);
		}
		
		//Verify if it's equal
		if (result == tempNum)
			System.out.println("Yep, it's equal, check it out: " + tempNum + " : " + result);
		else
			System.out.println("Nope, it's not, check it out: " + tempNum + " : " + result);
	}
	
}
