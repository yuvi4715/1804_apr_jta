package Assignment1;

import java.util.Scanner;

public class Q36Arithmetic
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the first number: ");
		int num1=Integer.parseInt(in.nextLine());
		System.out.print("Enter the second number: ");
		int num2=Integer.parseInt(in.nextLine());
		System.out.print("Enter an arithmetic operator: ");
		char op=in.next().charAt(0);
		
		in.close();
		
		switch(op)
		{
			case '+':
				System.out.println(num1+num2);
				break;
			case '-':
				System.out.println(num1-num2);
				break;
			case '*':
				System.out.println(num1*num2);
				break;
			case '/':
				System.out.println(num1/num2);
				break;
		}
	}
}
