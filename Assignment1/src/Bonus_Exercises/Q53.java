//John Eifert
package Bonus_Exercises;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Q53
{
	public static void main(String args[])
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> have = new ArrayList<Integer>();
		
		Scanner in = new Scanner(System.in);
		System.out.print("How long will the number array be? ");
		int s=in.nextInt();
		in.close();
		
		Random rand = new Random();
		
		int spot=0;
		while(spot==0)
		{
			spot=rand.nextInt(s);
		}
		
		for(int i=1; i<=s; i++)
		{
			if(i==spot)
			{
				int n=0;
				while(n==0)
				{
					n=rand.nextInt(s);
				}
				nums.add(n);
				System.out.print(n + " ");
				nums.add(i);
			}
			else
			{
				nums.add(i);
			}
			System.out.print(i + " ");
		}
		
		boolean has=false;
		have.add(nums.get(0));
		for(int i=1; i<s; i++)
		{
			has=have.contains(nums.get(i));
			
			if(has)
			{
				System.out.println("The duplicate is: " + nums.get(i));
				return;
			}
			
			have.add(nums.get(i));
		}
	}
}
