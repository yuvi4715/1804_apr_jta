//John Eifert
package Bonus_Exercises;

import java.util.ArrayList;

public class Q58
{
	public static void main(String args[])
	{
		int arr1[] = {1, 3, 5, 9};
		int arr2[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> both = new ArrayList<Integer>();
		
		//Loads arr1 into list:
		for(int i=0; i<arr1.length; i++)
		{
			list.add(arr1[i]);
		}
		
		//Finds all common elements between list and arr2, then loads them into both:
		for(int i=0; i<arr2.length; i++)
		{
			if(list.contains(arr2[i]))
			{
				both.add(arr2[i]);
			}
		}
		
		System.out.print("The common elements are: ");
		for(int i=0; i<both.size(); i++)
		{
			System.out.print(both.get(i) + " ");
		}		
	}
}
