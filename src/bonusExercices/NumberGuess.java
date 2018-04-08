package bonusExercices;
/**
* Dominick Sermeno
* Batch 1804
* BQ's: 66
*/
import java.util.Random;
import java.util.Scanner;

public class NumberGuess 
{

	public static void main(String[] args)
	{
		play();

	}

	
	public static void play()
	{
		Random rand = new Random();
		int answer = rand.nextInt(99);
		int input = 0;
		int count = 1;
		boolean wrong = true;
	    Scanner scan = new Scanner(System.in);
	    System.out.println("For testing purposes the answer is " + answer);
	    do 
	    {	    	
	    	System.out.println("Please guess a number between 0 and 99.");
	    	input = scan.nextInt();
	    	if(input == answer)
	    	{
	    		System.out.println("Congrats! You guessed right! You got it in " + count+ " tries.");
	    		wrong = false;
	    	}
	    	else if(input > answer )
	    	{
	    		System.out.println("Try Lower");
	    	}
	    	else
	    	{
	    		System.out.println("Try Higher" );
	    	}
	    	count++;
	    } 
	    while(wrong);
		scan.close();
	}
}
