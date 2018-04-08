//John Eifert
package Advanced_Coding_Exercises;

import java.util.Scanner;

public class Q45
{
	public static void main(String args[])
	{
		String input="";
		double num=0;
		
		boolean isValid=false;
		Scanner in = new Scanner(System.in);
		
		while(!isValid)
		{
			isValid=true;
			System.out.print("Please enter a nonzero, nonnegative, nondecimal number: ");
			input=in.nextLine();
			
			//Try to put the input into num and make the user try again if that cannot be done:
			try
			{
				num=Double.parseDouble(input);
			}
			catch(Exception e)
			{
				isValid=false;
				System.out.println("You entered something weird.  Please try again.");
			}
			if(isValid)
			{
				//Check to see if user entered 0, a negative number, or a decimal:
				if(num <= 0)
				{
					isValid=false;
					System.out.println(input + " is not a nonzero, nonnegative, nondecimal number.  Please try again.");
				}
				for(int i=0; i<input.length(); i++)
				{
					if(isValid && input.charAt(i) == '.')
					{
						isValid=false;
						System.out.println(input + " is not a nonzero, nonnegative, nondecimal number.  Please try again.");
					}
				}
			}
			if(isValid)
			{
				//Check to see if num is prime:
				if(num == 1 || num == 2)
				{
					System.out.println(input + " is a prime number.");
					return;
				}
				for(double i=2; i<num; i++)
				{
					if(num%i == 0)
					{
						System.out.println(input + " is not a prime number.");
						return;
					}
					System.out.println(i);
				}
				System.out.println(input + " is a prime number.");
				return;
			}
		}
		
		in.close();
	}
}
