package easyCodingExercises;

import java.util.Scanner;

public class KeyboardScanner 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int number = 0;
		double dblNum = 0.0;
		String word = ""; 
		System.out.println("Please enter: An Integer ");
		number  = input.nextInt();
		System.out.println("Please enter: A Double ");
		dblNum = input.nextDouble();
		System.out.println("Please enter: A String ");
		word = input.next();
		word += input.nextLine();
		
		System.out.println("Your Response: Int: " + number + " Double: " + dblNum +" String: " + word);
		input.close();
		
	}
}