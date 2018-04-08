//John Eifert
package Bonus_Exercises;

import java.util.Scanner;

public class Q46
{
	public static void main(String args[])
	{
		int num1;
		int num2;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter an int: ");
		num1=in.nextInt();
		System.out.print("Please enter another int: ");
		num2=in.nextInt();
		
		in.close();
		
		num1+=num2;
		num2=num1-num2;
		num1-=num2;
		
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		
	}
}
