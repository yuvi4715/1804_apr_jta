package bonusExercices;
/**
 * Dominick Sermeno
 * Batch 1804
 * BQ's: 48
 */
import java.math.BigInteger;
import java.util.Scanner;

public class Factorial 
{

	public static void main(String[] args) 
	{
		int num = 0;
		BigInteger passVal,answer = BigInteger.ONE;
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Please enter the factorial number");
	    num = scan.nextInt();
	    passVal = BigInteger.valueOf(num);
	    answer = factorial(passVal);
	    System.out.println(num + " factorial is: " + answer);
	    scan.close();// always close resources
	}

	
	public static BigInteger factorial(BigInteger number)
	{
	    BigInteger result = BigInteger.ONE;
	    for (long i = 2; i <= number.longValue(); i++)
	    {
	        result = result.multiply(BigInteger.valueOf(i));
	    }
	    return result;
	}
}
