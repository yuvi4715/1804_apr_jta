package Bonus_Exercises;

import java.util.Scanner;

public class Q55
{
	public static void main(String args[])
	{
		System.out.print("Please enter an integer: ");
		
		Scanner in = new Scanner(System.in);
		int num=in.nextInt();
		in.close();
		
		
		if(num == (num/2)*2)
		{
			System.out.println(num + " is an even number.");
			return;
		}
		System.out.println(num + " is an odd number.");
	}
}
