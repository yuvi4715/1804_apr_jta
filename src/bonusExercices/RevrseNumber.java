package bonusExercices;
/**
 * Dominick Sermeno
 * Batch 1804
 * BQ's: 52
 */
import java.util.Scanner;

public class RevrseNumber
{

	public static void main(String[] args) 
	{
		int input = 0;
		String temp,reverse = "";
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Please enter the integer to be reversed.");
	    input = scan.nextInt();
	    temp = Integer.toString(input);
	    for ( int i = temp.length() - 1 ; i >= 0 ; i-- )
	      {
	         reverse = reverse + temp.charAt(i);
	      }
	    input = Integer.parseInt(reverse);
	    System.out.println("The reverse number is: " + input);
	    scan.close(); // always close resources
	}

}
