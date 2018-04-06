package Bonus;

public class Problem48 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int factorial=1;
		
		//number to calculate factorial of.
		int num=9;
		  
		for(int i=1; i <= num; i++)
		{    
			factorial = factorial * i;    		  
		}    
		  
		System.out.println("Factorial of "+num+" is: "+factorial);     
	}  
}
