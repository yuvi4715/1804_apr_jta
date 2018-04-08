//John Eifert
package Bonus_Exercises;

import java.util.Scanner;

public class Q48
{
	public static void main(String args[])
	{
		System.out.print("Please enter an integer: ");
		Scanner in = new Scanner(System.in);
		
		int num=in.nextInt();
		int factorial=1;
		int store=num;
		
		in.close();
		
		while(num>1)
		{
			factorial=factorial*num;
			num--;
		}
		
		System.out.println(store + " factorial = " + factorial);
	}
}
