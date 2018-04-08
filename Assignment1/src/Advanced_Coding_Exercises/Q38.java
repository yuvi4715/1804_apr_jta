//John Eifert
package Advanced_Coding_Exercises;

import java.util.Scanner;

public class Q38
{
	public static void main(String args[])
	{
		//Reads the string in:
		Scanner in = new Scanner(System.in);
		
		String newString=" ";
		char replace=' ';
		char newChar=' ';
		boolean isValid=false;
		while(isValid==false)
		{
			System.out.println("Please enter a string: ");
			try
			{
				isValid=true;
				String workaround= new String(in.nextLine());
				newString=workaround;
			}
			catch(Exception e)
			{
				isValid=false;
				System.out.println("You tried to enter something weird.  Please try again.");
			}
		}
		
		//Read the old character in:
		isValid=false;
		while(!isValid)
		{
			System.out.println("Please enter the character to be replaced: ");
			try
			{
				isValid=true;
				replace=in.nextLine().charAt(0);
			}
			catch(Exception e)
			{
				isValid=false;
				System.out.println("You tried to enter something weird.  Please try again.");
			}
		}
		
		//Read the new character in:
				isValid=false;
				while(!isValid)
				{
					System.out.println("Please enter the character to be inserted: ");
					try
					{
						isValid=true;
						newChar=in.nextLine().charAt(0);
					}
					catch(Exception e)
					{
						isValid=false;
						System.out.println("You tried to enter something weird.  Please try again.");
					}
				}
		
		//Do the replacement:
		String rString=newString.replace(replace, newChar);
		System.out.println(rString);
		
		in.close();
	}
}
