//John Eifert
package Bonus_Exercises;

public class Q62
{
	public static void main(String args[])
	{
		double divideBy=1;
		double myPi=0;
		boolean add=true;
		
		//Uses the Gregory-Leibniz series to calculate pi:
		for(int i=0; i<1000000; i++)
		{
			if(add)
			{
				myPi+=(4/divideBy);
				add=false;
			}
			else
			{
				myPi-=(4/divideBy);
				add=true;
			}
			
			divideBy+=2;
		}
		
		System.out.println("I calculate pi to be approximately equal to: " + myPi);
		System.out.println("The JDK's pi value is: " + Math.PI);
		
		System.out.println("My calculation for pi is off from the JDK's by: " + ((Math.abs((myPi-Math.PI))/Math.PI)*100) + " percent of the JDK's pi.");
	}
}
