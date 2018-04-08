package bonusExercices;
/**
 * Dominick Sermeno
 * Batch 1804
 * BQ's: 46
 */
import java.util.Scanner;

public class SwapInts 
{

	public static void main(String[] args) 
	{
		   	int num1, num2 = 0;
		    Scanner scan = new Scanner(System.in);
		    System.out.println("Please enter the first number");
		    num1 = scan.nextInt();
		    System.out.println("Please enter the second number");
		    num2 = scan.nextInt();
		    System.out.println("The first number is: " + num1 + 
		    		" the second number is: " + num2);
		    num1 = num1+num2;
		    num2 = num1-num2;
		    num1 = num1-num2;
		    System.out.println("The first number is now: " + num1 + 
		    		" the second number is now: " + num2);
		    scan.close();// always close resources 
	}

}
