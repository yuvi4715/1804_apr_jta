package advancedCodingExercices;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 40
 */
import java.math.BigInteger;

public class fibonaiccci 
{

	public static void main(String[] args) 
	{
		BigInteger fib1;
		BigInteger fib2;
		for(BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.valueOf(100)) < 0 ; i = i.add(BigInteger.ONE))
		{
			System.out.println("Normal At:" + i + "  ");
			fib1 = fibonacci(i);
			System.out.println(fib1);
			
		}
		
		//THIS CODE WORKS FINE...HOWEVER IT WILL TAKE MANY CYCLES TO RUN
		
		for(BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.valueOf(100)) < 0 ; i = i.add(BigInteger.ONE))
		{
			System.out.println("Recusive At:" + i + "  ");
			fib2 =  recusive(i);
			System.out.println(fib2);
		}
	}

	


	
	public static BigInteger fibonacci(BigInteger n)
	{
		BigInteger result = BigInteger.ZERO; 
		BigInteger n1 = BigInteger.ZERO;
		BigInteger n2 = BigInteger.ZERO;
		if(n.equals(BigInteger.ZERO))
		{
			result = BigInteger.ZERO;
		}
		if(n.equals(BigInteger.ONE))
		{
			result = BigInteger.ONE;
		}
		else
		{
			n1 = BigInteger.ONE;
			n2 = BigInteger.ZERO;
			for (BigInteger i = BigInteger.ONE; i.compareTo(n) < 0 ; i = i.add(BigInteger.ONE))
			{
				result = n1.add(n2);
				n2 = n1;
				n1 = result;
			}	
		}
		return result;
	}
	
	
	
	// WARNING THIS WILL SLOW DOWN YOUR MACHINE RUN AT YOUR OWN RISK!!!!
	public static BigInteger recusive(BigInteger n)
	{
		 if(n.equals(BigInteger.ZERO))
		{
		        return BigInteger.ZERO;
		}
		else if(n.equals(BigInteger.ONE))
		{
		      return BigInteger.ONE;
		}
		else
		{
			return (recusive(n.subtract(BigInteger.ONE))).add((recusive(n.subtract(BigInteger.valueOf(2)))));
		}
		
	}
	
	
	

}
