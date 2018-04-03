package quest1;

import java.util.Scanner;

public class question1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Number to perform Compute");
		
		System.out.println("Enter the 1st Value");
		int first_value = scan.nextInt();
		
		System.out.println("Enter the 2nd Value");
		int second_value = scan.nextInt();
		
		System.out.println("Enter the option to be performed");
		System.out.println("1 for Addition");
		System.out.println("2 for Subtraction");
		System.out.println("3 for Multiplication");
		System.out.println("4 for Division");
		
		int operation = scan.nextInt();
		int answer;
		if(operation == 1) {
			 answer = first_value + second_value;
		}
		else if(operation == 2) {
			 answer = first_value - second_value;
		}
		else if(operation == 3) {
			 answer = first_value * second_value;
		}
		else {
			 answer = first_value / second_value;
		}
		
		System.out.println("Output = " + answer );

	}

}
