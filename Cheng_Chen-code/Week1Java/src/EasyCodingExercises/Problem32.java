package EasyCodingExercises;

import java.util.Scanner;

public class Problem32 {
	public static void main(String[] args) 
	{
		System.out.println("Enter Number: ");
		Scanner in = new Scanner(System.in);	
		int mark = 0;
		
		if(in.hasNextInt())
			mark = in.nextInt();
		
		if(mark >= 50) 
			System.out.println("PASS");
		else 
			System.out.println("FAIL");
	}
}
