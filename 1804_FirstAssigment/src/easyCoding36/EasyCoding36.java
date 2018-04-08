package easyCoding36;

import java.util.Scanner;
import java.util.StringTokenizer;


//Write a program called Arithmetic that takes three command-line arguments: 
//two integers followed by an arithmetic operator (+, -, * or /). 
//The program shall perform the corresponding operation on the two integers and print the result.
	

public class EasyCoding36 
{
	
		public static void main(String[] args) 
		{
			Arithmetic();
		}

		public static void Arithmetic() 
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Enter two integers, followed by an operator (+, -, * or /).");
			String str = input.nextLine();
			StringTokenizer tokenized = new StringTokenizer(str);
			int result = 0;
			
			int Number1 = Integer.parseInt(tokenized.nextToken());
			int Number2 = Integer.parseInt(tokenized.nextToken());
			String op = tokenized.nextToken();
			
			if (op.equals("+"))
				result = Number1 + Number2;
			else if (op.equals("-"))
				result = Number1 - Number2;
			else if (op.equals("*"))
				result = Number1 * Number2;
			else if (op.equals("/"))
				result = Number1 / Number2;
			
			//Testing modulo %
			else if (op.equals("%"))
				result = Number1 % Number2;
			
			System.out.println("Result is: " + result);
			
			input.close();
		}
}

