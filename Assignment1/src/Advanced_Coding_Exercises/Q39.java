//John Eifert
package Advanced_Coding_Exercises;

import java.util.Scanner;
import java.util.Calendar;

public class Q39
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		Calendar cal = Calendar.getInstance();
		
		int mon=0;
		boolean isValid=false;
		while(!isValid)
		{
			isValid=false;
			while(!isValid)
			{
				System.out.println("Please enter the number of your birthmonth: ");
				try
				{
					isValid=true;
					mon=Integer.parseInt(in.nextLine());
				}
				catch(Exception e)
				{
					isValid=false;
					System.out.println("You tried to enter something weird.  Please try again.");
				}
			}
			
			if((isValid && mon<1) || (isValid && mon>12))
			{
				System.out.println("You have entered an invalid month value.  Please try again.");
				isValid=false;
			}
		}
		mon--;	//because cal's months are zero-indexed
		
		int d=0;
		isValid=false;
		while(!isValid)
		{
			isValid=false;
			while(!isValid)
			{
				System.out.println("Please enter the number of your birthday: ");
				try
				{
					isValid=true;
					d=Integer.parseInt(in.nextLine());
				}
				catch(Exception e)
				{
					isValid=false;
					System.out.println("You tried to enter something weird.  Please try again.");
				}
			}
			
			if((isValid && d<1) || (isValid && d>31))
			{
				System.out.println("You have entered an invalid day value.  Please try again.");
				isValid=false;
			}
		}

		if(cal.getTime().getDate() == d && cal.getTime().getMonth() == mon)
		{
			System.out.println("Happy Birthday to you");
			System.out.println("Happy Birthday to you");
			System.out.println("Happy Birthday Dear user");
			System.out.println("Happy Birthday to you.");
		}
		else
		{
			System.out.println("It is not your birthday.");
		}
		
		in.close();
	}
}
