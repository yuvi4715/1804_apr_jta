//John Eifert
package Bonus_Exercises;

import java.util.ArrayList;

public class Q60
{
	public static void main(String args[])
	{
		int arr[] = {0, 1, 2, 1, 5, 7, 7, 7, 9, 8, 0, 6, 4, 2, 2, 3};
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean has;
		
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
			has=list.contains(arr[i]);
			
			if(!has)
			{
				list.add(arr[i]);
			}
		}
		
		System.out.print("The unique entries of arr are: ");
		for(int i=0; i<list.size(); i++)
		{
			System.out.print(list.get(i) + ", ");
		}
	}
}
