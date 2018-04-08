package bonusExercices;

import java.util.Scanner;
/**
 * Dominick Sermeno
 * Batch 1804
 * BQ's: 57
 */
public class Palindrome 
{

	public static void main(String[] args) 
	{
		 String input, reverse = "";
	     Scanner scan = new Scanner(System.in);
	     System.out.println("Please enter the message to be compared.");
	     input = scan.nextLine();
	     for ( int i = input.length() - 1 ; i >= 0 ; i-- )
	     {
	        reverse = reverse + input.charAt(i);
	     }
	     if(input.equals(reverse))
	     {
	    	 System.out.println(input + " is a palindrome!");
	     }
	     else
	     {
	    	 System.out.println(input + " is NOT a palindrome!");
	     }
	     scan.close();
	}

}
