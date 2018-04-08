//John Eifert
package Bonus_Exercises;

import java.util.Scanner;
import java.lang.StringBuilder;

public class Q52
{
	public static void main(String args[])
	{
		System.out.print("Please enter a nonnegative, nondecimal number: ");
		Scanner in = new Scanner(System.in);
		long num=in.nextLong();
		in.close();
		
		String numStr=Long.toString(num);
		StringBuilder rev = new StringBuilder();
		rev.append(numStr);
		rev.reverse();
		String revStr=rev.toString();
		num=Long.parseLong(revStr);
		
		System.out.println(numStr + " reversed is: " + num);
	}
}
