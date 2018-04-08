//John Eifert
package Advanced_Coding_Exercises;

import java.util.Scanner;

public class Q44
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String str=in.nextLine();
		in.close();
		
		char[] chars=str.toCharArray();
		char[] newChars=str.toCharArray();
		int counter=chars.length-1;
		
		for(int i=0; i<chars.length; i++)
		{
			newChars[counter]=chars[i];
			counter--;
		}

		String newStr=String.valueOf(newChars);
		
		System.out.println("The reversed form of your string is:");
		System.out.println(newStr);
		
	}
}
