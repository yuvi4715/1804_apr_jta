package Bonus;

public class Problem57 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] test ={1, 60, 35, 22, 45, 999, 5, 12, 53};  
		System.out.println("Unsorted Array:");
		for(int i = 0; i < test.length; i++)
			System.out.print(test[i] + " ");
		
		System.out.println();
		
		sort(test);
		
		System.out.println("Sorted Array:");
		for(int i = 0; i < test.length; i++)
			System.out.print(test[i] + " ");

	}
	
	public static void sort(int[] unsorted)
	{
		int l = unsorted.length;
		int temp = 0;
		
		for(int i = 0; i < l; i++)
		{
			for(int j = 1; j < (l-i); j++)
			{
				if(unsorted[j-1] > unsorted[j])
				{
					temp = unsorted[j-1];
					unsorted[j-1] = unsorted[j];
					unsorted[j] = temp;
				}
			}
		}
	}
}
