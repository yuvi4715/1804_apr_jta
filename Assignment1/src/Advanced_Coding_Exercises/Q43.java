//John Eifert
package Advanced_Coding_Exercises;

import java.util.Scanner;

public class Q43
{
	public static void main(String args[])
	{
		String input="";
		double testForNum=0;
		long num=0;
		double sum=0;
		
		Scanner in = new Scanner(System.in);
		
		boolean isValid=false;
		while(!isValid)
		{
			isValid=true;
			System.out.print("Please enter a number: ");
			input=in.nextLine();
			
			try
			{
				testForNum=Double.parseDouble(input);
			}
			catch(Exception e)
			{
				isValid=false;
				System.out.println("You entered something weird.  Please try again.");
			}
			if(isValid)
			{
				for(int i=0; i<input.length(); i++)
				{
					if(input.charAt(i) == '.')
					{
						System.out.println(input + " is not Armstrong.");
						return;
					}
				}
				if(testForNum > Long.MAX_VALUE)
				{
					isValid=false;
					System.out.println("That number is larger than what this program is designed to deal with.");
				}
			}
			if(isValid)
			{
				//Check to make sure that the sum of the digits' cubes is within the size of a double:
				num=(long) testForNum;
				
				try
				{
					for(int i=0; i<Long.toString(num).length(); i++)
					{
						sum+=Math.pow(Long.parseLong(Long.toString(num).substring(i, i+1)), 3);
					}
				}
				catch(Exception e)
				{
					isValid=false;
					System.out.println("That number is larger than what this program is designed to deal with.");
				}
				if(isValid && num == sum)
				{
					System.out.println(num + " is an Armstrong number.");
					return;
				}
				else if(isValid)
				{
					System.out.println(num + " is not an Armstrong number.");
					return;
				}
			}
		}
		
		in.close();
	}
}
