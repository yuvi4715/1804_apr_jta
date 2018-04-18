package easyCodingExercises;


import java.util.Scanner;

public class Problem35 {
	
	
	//Write a program called KeyboardScanner 
	//to prompt user for an int, a double, and a String. 
	//Print the input onto the console.
	
	public static void main(String[] args) {
		
		keyboardScanner();
		
	}
	
	
	
	public static void keyboardScanner() {
		
		Scanner cin = new Scanner(System.in);
		
		System.out.println("Please type an integer: ");
		Integer inputInt = Integer.valueOf(cin.nextLine());
		
		System.out.println("Please type a double: ");
		Double inputDouble = Double.valueOf(cin.nextLine());
		
		System.out.println("Please type a String: ");
		String inputString = cin.nextLine();
		
		System.out.println("   Your int: " + inputInt);
		System.out.println("Your double: " + inputDouble);
		System.out.println("Your String: " + inputString);
		
		cin.close();
		
		
		
		
		
		
	}
	
	
	

}
