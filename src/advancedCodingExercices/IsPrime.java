package advancedCodingExercices;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 45
 */
public class IsPrime 
{

	public static void main(String[] args) 
	{
		for(int i = 0; i < 50; i++)
		{
			System.out.println("At: " + i + " The next Prime Number is: ");
			nextPrime(i);
		}

	}
	
	public static void nextPrime(int prime)
	{
		boolean isPrime = false;
	    int start = 2;
	    while (!isPrime)
	    {
	    	prime += 1;
	        int m = (int) Math.ceil(Math.sqrt(prime));

	        isPrime = true;
	        for (int i = start; i <= m; i++)
	        {
	            if (prime % i == 0) 
	            {
	                isPrime = false;
	                break;
	            } 
	        }
	    }
	    System.out.println(prime);
	}

}
