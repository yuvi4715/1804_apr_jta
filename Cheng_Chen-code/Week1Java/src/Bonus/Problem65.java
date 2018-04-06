package Bonus;
import java.util.*;

public class Problem65 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Random rnum = new Random();
		  Scanner in = new Scanner(System.in);
		  int answer =  rnum.nextInt(99);
		  int numTries = 0;
		  int guess = 0;
		  
		  System.out.println("Please guess an integer betwen 0 and 99: ");		
		  
		  while (true)
		  {		                
			  guess = in.nextInt();		        
			  numTries++;
		           
			  if (guess < 0 || guess > 99)		              
				  System.out.println("Invalid input");		           
			  else if (guess == answer)	           
			  {		              
				  System.out.println("Congratulations you guessed the number! \nYou got it in "+ numTries + " tries.");		              
				  break;		           
			  }		           
			  else if (guess < answer)		              
				  System.out.println("Try higher.");		           
			  else if (guess > answer)		              
				  System.out.println("Try lower."); 
		  }
 
	}
}
