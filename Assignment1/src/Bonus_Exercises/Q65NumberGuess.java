//John Eifert
package Bonus_Exercises;

import java.util.Scanner;
import java.util.Random;

public class Q65NumberGuess
{
	public static void main(String args[])
	{
		Random rand = new Random();
		int num=rand.nextInt(100);
		int tries=1;
		
		System.out.println("Please guess an integer between 0 and 99: ");
		Scanner in = new Scanner(System.in);
		int guess=in.nextInt();
		
		while(guess != num)
		{
			if(guess < num)
			{
				System.out.println("Try higher.");
				guess=in.nextInt();
			}
			else
			{
				System.out.println("Try lower.");
				guess=in.nextInt();
			}
			tries++;
		}
		in.close();
		
		System.out.println("You got in in " + tries + " tries!");
	}
}
