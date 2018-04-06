//John Eifert
package Class_Members;

public class Q7
{
	public static class Customer
	{
		static int something=0;
		final static boolean fact=true;
		int num;
		String name;
		
		Customer(int n)
		{
			num=n;
		}
		Customer(String n)
		{
			name=n;
		}
		Customer(int n, String na)
		{
			num=n;
			name=na;
		}
		
		
		public static void showSomething()
		{
			System.out.println(something);
		}
		public static void showFact()
		{
			System.out.println(fact);
		}
		
		public void increase(int amount)
		{
			num+=amount;
			System.out.println(num);
			return;
		}
		public void increase(int factor, char op)
		{
			if(op == '+')
			{
				increase(factor);
			}
			else
			{
				if(op == '*')
				{
					num*=factor;
					System.out.println(num);
				}
				else
				{
					System.out.println("You have entered an invalid increase operation.");
				}
			}
			return;
		}
	}
}
