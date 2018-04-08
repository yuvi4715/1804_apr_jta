package advancedCoding40;

import java.util.Scanner;

//Write a Java program to print the first 100 Fibonacci numbers using iteration. 
//Rewrite using recursion.


public class AdvancedCoding40 
{

	public static void main(String[] args) 
	{
	
		System.out.println("Enter number up to which Fibonacci series to print: ");
		
		@SuppressWarnings("resource")
		int number = new Scanner(System.in).nextInt();
		
		System.out.println("Fibonacci series up to " + number + " numbers: ");
		
		for(int i=1; i<=number; i++) 
		{
		
			System.out.print(fibonacci(i) + " "); 
			{
				
			}
		}
		}
	
		
		public static int fibonacci(int number) 
		{
			if(number == 1 || number == 2)
			{
				return 1;
			}
			int fibo1=1, fibo2=1, fibonacci=1; 
			for(int i= 3; i<= number; i++)
			{
				fibonacci = fibo1 + fibo2; 
				fibo1 = fibo2; 
				fibo2 = fibonacci;

			}
			return fibonacci;
		}
		
}
