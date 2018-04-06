//John Eifert
package Core_Java;

public class Q2 
{
	public static void main(String args[])
	{
		int num1 = 0;
		int num2 = 2;
		int num3 = 1;
		
		if(num1 >= num2 && num1 >= num3)
		{
			System.out.println("The greatest among the given numbers is " + num1);
		}
		else
		{
			if(num2 >= num1 && num2 >= num3)
			{
				System.out.println("The greatest among the given numbers is " + num2);
			}
			else
			{
				System.out.println("The greatest among the given numbers is " + num3);
			}
		}
	}
}
