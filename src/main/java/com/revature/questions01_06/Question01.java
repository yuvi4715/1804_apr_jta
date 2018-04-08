package com.revature.questions01_06;

public class Question01 {

	//***There is likely nothing wrong with my packages but please message me if there is.
	
	/*For my assignment questions I should've used jUnit but it took longer than expected to go back and
	 *fix my answers and could not. However, I've attempted to format the main methods in a way that would
	 *translate to jUnit test cases. 
	 */
	
	static final int a =  77;
	static final int b =  200;
	//There is a way to manipulate final ints with reflection but static finals are significantly more difficult.
	//Also I don't think it would be good practice to go around changing final variables.
	
	public static void main(String[] args) {
		
		manipulate_hardcoded_numbers(a, b);
	}
	
	public static void manipulate_hardcoded_numbers(int a, int b) {
		
		System.out.println("a = " + a + "\nb = " + b);
		System.out.println("Addition: " + Double.toString(a + b));
		System.out.println("Subtraction: " + Double.toString(a - b));
		System.out.println("Multiplication: " + Double.toString(a * b));
		System.out.println("Division: " + Double.toString(a / b));

	}
}
