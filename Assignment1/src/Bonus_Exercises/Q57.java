//John Eifert
package Bonus_Exercises;

public class Q57
{
	public static void main(String args[])
	{
		int arr[] = {5, 0, 3, 2, 1, 4, 8, 7, 9, 6};
		int storage=0;
		
		System.out.print("The original form of arr is: ");
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
		
		while(!sorted(arr))
		{
			for(int i=1; i<arr.length; i++)
			{
				if(arr[i] < arr[i-1])
				{
					storage=arr[i];
					arr[i]=arr[i-1];
					arr[i-1]=storage;
				}
			}
		}
		
		System.out.print("The sorted form of arr is: ");
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}	
	}

	
	static boolean sorted(int arr[])
	{
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] < arr[i-1])
			{
				return(false);
			}
		}
		return(true);
	}
}
