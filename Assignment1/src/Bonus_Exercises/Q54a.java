//John Eifert
package Bonus_Exercises;

import java.util.Scanner;
import java.util.ArrayList;

public class Q54a
{
	public static void main(String args[])
	{
		System.out.print("Please enter a string: ");
		Scanner in = new Scanner(System.in);
		String str=in.nextLine().toLowerCase();
		in.close();
		ArrayList<Character> list = new ArrayList<Character>();
		ArrayList<Character> dupes = new ArrayList<Character>();
		list.add(str.charAt(0));
		
		for(int i=1; i<str.length(); i++)
		{
			if(list.contains(str.charAt(i)) && !dupes.contains(str.charAt(i)))
			{
				dupes.add(str.charAt(i));
			}
			else
			{
				list.add(str.charAt(i));
			}
		}
		
		System.out.print("The duplicate characters contained in the provided string are: ");
		for(int i=0; i<dupes.size(); i++)
		{
			System.out.print(dupes.get(i) + " ");
		}
	}
}
