package advancedCodingExercices;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 44
 */
import java.util.Scanner;

public class ReverseString 
{

	public static void main(String[] args)
	{
	      String input, reverse = "";
	      Scanner scan = new Scanner(System.in);
	      System.out.println("Plesae enter the message to be reversed.");
	      input = scan.nextLine();
	      for ( int i = input.length() - 1 ; i >= 0 ; i-- )
	      {
	         reverse = reverse + input.charAt(i);
	      }
	      System.out.println("Reverse of entered string is: " + reverse);
	      scan.close();
	}

}
