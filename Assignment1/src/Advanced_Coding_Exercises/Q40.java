//John Eifert
package Advanced_Coding_Exercises;

import java.math.BigInteger;

public class Q40
{
	public static void main(String args[])
	{
		iter(100);
		
		recur(0, new BigInteger("1"), new BigInteger("0"));
	}
	
	
	//Iterative Fibonacci method:
	private static void iter(int stop)
	{
		BigInteger numNow = new BigInteger("1");
		BigInteger numOld = new BigInteger("0");
		BigInteger storage = new BigInteger("0");
		
		for(int i=0; i<stop; i++)
		{
			//Print the current Fibonacci number:
			System.out.println(numNow);
			
			//Find the next Fibonacci number:
			storage=numNow;
			numNow=numNow.add(numOld);
			numOld=storage;
		}
	}
	
	
	//Recursive Fibonacci method:
	private static void recur(int c, BigInteger nN, BigInteger nO)
	{
		BigInteger numNow=nN;
		BigInteger numOld=nO;
		BigInteger storage;
		
		if(c == 100-1)
		{
			System.out.println(numNow);
		}
		else if(c < 100-1)
		{
			//Print the current Fibonacci entry:
			System.out.println(numNow);
			
			//Find the next Fibonacci number:
			storage=numNow;
			numNow=numNow.add(numOld);
			numOld=storage;
			
			//Do it all again:
			recur(++c, numNow, numOld);
		}
	}
}
