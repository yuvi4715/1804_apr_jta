package easyCoding35;

import java.util.Scanner;

//Write a program called KeyboardScanner to prompt user for an int, a double, and a String. 
//Print the input onto the console.

public class EasyCoding35 
{
	
	public static void main(String[] args) 
	
	{
		KeyboardScanner();
		
	}
	
	public static void KeyboardScanner() 
	
	{
				int UserInputInt;
				String UserInputString;
				double UserInputDouble;
				
				Scanner input = new Scanner(System.in);
				System.out.println("Type an int: ");
				
				UserInputInt = input.nextInt();
				System.out.println("You entered: " + UserInputInt + "\n");
				System.out.println("Type a string: ");
				
				UserInputString= input.next();
				System.out.println("You entered: "+ UserInputString + "\n");
				System.out.println("Type a double: ");
				
				UserInputDouble = input.nextDouble();
				System.out.print("You entered: " + UserInputDouble + "\n");
				input.close();
	}
}


