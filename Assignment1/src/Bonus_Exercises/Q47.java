//John Eifert
package Bonus_Exercises;

import java.util.LinkedList;

public class Q47
{
	public static void main(String args[])
	{
		LinkedList<Boolean> list = new LinkedList<Boolean>();
		int num=9;
		
		for(int i=0; i< num; i++)
		{
			if(i==num/2)
			{
				list.add(true);
			}
			else
			{
				list.add(false);
			}
		}
				
		if(list.size()%2 == 0)
		{
			System.out.println("The provided LinkedList has an even number of nodes and, therefore, does not have a middle node.");
			return;
		}
		
		System.out.println("The middle node of the provided LinkedList is: " + list.get(list.size()/2));
	}
}
