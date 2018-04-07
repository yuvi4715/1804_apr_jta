package AdvancedCodingPrograms;
/**Write a Java program that prints the numbers from 1 to 50. 
 * But for multiples of three print "Fizz" instead of the number
 *  and for the multiples of five print "Buzz". 
 *  For numbers which are multiples of both three and five print "FizzBuzz"
 */

public class NumberPrint {
	public static void main(String[] args) {
		
		for(int i=1; i<=50; i++)
		{
			if(checkRepeats(i)) continue;
			else System.out.println(i);
		}
		
	}
	
	public static boolean checkRepeats(int x) {
		if (x%3 ==0 && x%5==00) 
		{	System.out.println("FizzBuzz"); 
			return true;
		}
		if (x%3 ==0) {System.out.println("Fizz"); return true;}
		if (x%5 ==0) {System.out.println("Buzz"); return true;}
		return false;
		
		
	}

}

