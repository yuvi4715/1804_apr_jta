//John Eifert
package Advanced_Coding_Exercises;

public class Q41
{
	public static void main(String args[])
	{
		boolean divisable;
		
		for(int i=1; i<=50; i++)
		{
			divisable=false;
			if(i%3 == 0)
			{
				divisable=true;
				System.out.print("Fizz");
			}
			if(i%5 == 0)
			{
				divisable=true;
				System.out.print("Buzz\n");
				
			}
			else if(divisable)
			{
				System.out.print("\n");
			}
			if(!divisable)
			{
				System.out.println(i);
			}
		}
	}
}
