import java.util.Scanner;

public class Problem33 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter Number: ");
		Scanner in = new Scanner(System.in);	
		int number = 0;
		
		if(in.hasNextInt())
			number = in.nextInt();
		
		if((number%2)==0) 
			System.out.println("Even.");
		else 
			System.out.println("Odd.");
	}
}
