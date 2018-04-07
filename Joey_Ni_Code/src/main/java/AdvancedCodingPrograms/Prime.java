package AdvancedCodingPrograms;
/**A prime number (or a prime) is a natural number greater than 1
 *  that cannot be formed by multiplying two smaller natural numbers. 
 *  A natural number greater than 1 that is not prime is called a 
 *  composite number. For example, 5 is prime because the only ways 
 *  of writing it as a product, 1 × 5 or 5 × 1, involve 5 itself.
 *   However, 6 is composite because it is the product of two
 *    numbers (2 × 3) that are both smaller than 6. 
 *    Primes are central in number theory because of the 
 *    fundamental theorem of arithmetic: every natural number 
 *    greater than 1 is either a prime 
 * itself or can be factorized as a product of primes that is unique up to their order.
 * @author joeyi
 *
 */
//8. Write a method to determine if a number is prime. 

public class Prime {
	
	public static void main(String[] args) {
		System.out.println("1"+isPrime(1));
		System.out.println("2"+isPrime(2));
		System.out.println("3"+isPrime(3));
		System.out.println("4"+isPrime(4));
		System.out.println("5"+isPrime(5));
		System.out.println("6"+isPrime(6));
		System.out.println("10"+isPrime(10));
		System.out.println("11"+isPrime(11));
		System.out.println("14"+isPrime(14));
		System.out.println("17"+isPrime(17));
		System.out.println(isPrime(11111));
	}
	
	public static boolean isPrime(int n)
	{
		if (n==1) return true;
		else if (n>=1) {
			for(int i=2; i<n;i++)
			{
				if(n%i==0) return false; 
				//divide by every number to check if any number is divisible
			}
		}
			
		return true;
	}
}
