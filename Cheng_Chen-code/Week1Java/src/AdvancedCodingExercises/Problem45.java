package AdvancedCodingExercises;
import java.util.Scanner;

public class Problem45 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number: ");
		int number;
		number=in.nextInt();
		in.close();
		
		if(isPrime(number))
			System.out.println("The number is prime.");
		else
			System.out.println("The number is not prime.");
		
	}
	
	public static boolean isPrime(int n)
	{
		for(int i = 2; i < n; i++) 
	        if(n%i == 0)
	            return false;
		
	    return true;
	}
}
