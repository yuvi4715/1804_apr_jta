//John Eifert
package Bonus_Exercises;

public class Q56
{
	public static void main(String args[])
	{
		String pal = "racecar";
		StringBuilder lap = new StringBuilder(pal);
		
		if(pal.equalsIgnoreCase((lap.reverse()).toString()))
		{
			System.out.println(pal + " is a palindrome.");
			return;
		}
		
		System.out.println(pal + " is not a palindrome.");
	}
}
