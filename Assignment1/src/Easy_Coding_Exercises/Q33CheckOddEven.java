//John Eifert
package Easy_Coding_Exercises;

import java.util.Scanner;

public class Q33CheckOddEven
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the number: ");
		int number=Integer.parseInt(in.nextLine());
		
		in.close();
		
		if(number%2 == 1)
		{
			System.out.println("Odd number");
		}
		else
		{
			System.out.println("Even number");
		}
	}
}
