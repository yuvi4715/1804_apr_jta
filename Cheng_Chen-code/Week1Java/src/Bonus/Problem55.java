package Bonus;
import java.util.Scanner;

public class Problem55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter Number: ");
		Scanner in = new Scanner(System.in);	
		int number = 0;
		
		if(in.hasNextInt())
			number = in.nextInt();
		
		if((number / 2) * 2 == number) 
			System.out.println("Even.");
		else 
			System.out.println("Odd.");
	}

}
