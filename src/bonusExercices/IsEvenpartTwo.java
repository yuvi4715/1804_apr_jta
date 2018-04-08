package bonusExercices;
/**
* Dominick Sermeno
* Batch 1804
* BQ's: 56
*/
import java.util.Scanner;

public class IsEvenpartTwo 
{

	public static void main(String[] args) 
	{
		int input = 0;
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Please enter the integer to be checked.");
	    input = scan.nextInt();
	    isEven(input);
	    scan.close(); // always close resources 
	}

	public static void isEven(int num)
	{
		int isEven = 0;	
		isEven = num/2;
		if(isEven *2 == num)
		{
		   System.out.println( num +" is an Even number");

		}
		else
		{
			System.out.println(num + " is an Odd number");
		}
	}

}
