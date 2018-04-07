package com.revature.questions01_06;
import java.util.Scanner;

public class Questions01_06 {

	public static void main(String[] args) {
		
		//question_1();
		//question_2(4, 5, 7);
		//question_3();
		//question_4(40, 88);
		//question 5 main method in another class workoutput1_6. 
		//question_6();
	}	
	

	public static void question_1() {
		
		double a = 80;
		double b = 40;
		
		System.out.println("a = 80 \nb = 40");
		System.out.println("Addition: " + Double.toString(a + b));
		System.out.println("Subtraction: " + Double.toString(a - b));
		System.out.println("Multiplication: " + Double.toString(a * b));
		System.out.println("Division: " + Double.toString(a / b));

	}
	
	public static void question_2(double a, double b, double c) {
		
		double biggest;
        if( a>b && a> c)
        	biggest = a;
        else if(b>a && b>c)
        	biggest = b;
        else
        	biggest = c;
         
        System.out.println("Greatest of three numbers: "+ biggest);
	}
	
	public static void question_3() {
		
		boolean a = true;
		boolean b = false;
		
		System.out.print("!a: ");
		System.out.println(!a);
		System.out.print("a|b: ");
		System.out.println(a|b);
		System.out.print("(!a & b) | (a & !b): ");
		System.out.println((!a & b) | (a & !b));
	}
	
	public static void question_4(double a, double b) {
		
		System.out.println("Addition: " + Double.toString(a + b));
		System.out.println("Subtraction: " + Double.toString(a - b));
		System.out.println("Multiplication: " + Double.toString(a * b));
		System.out.println("Division: " + Double.toString(a / b));

	}
	
	public static void question_6() {
		Scanner sc = new Scanner(System.in);
		
		int anynumber;
		int i = 0;
		
		System.out.println("Enter random whole number:");
		anynumber = sc.nextInt();
		
		if (anynumber > 10) {
			System.out.println("Your number is greater than ten.");
		}
		else{
			System.out.println("Your number is ten or less.");
		}
		
		System.out.println("Count up to number with a while loop.");
		while(i <= anynumber) {
			System.out.print(i + " ");
			i++;
		}
		
		System.out.println("\nNow to count down using a for loop:");
		for(int j = i; j > 0; j-=1) {
			System.out.print(j + " ");	
		}
		
		sc.close();
	}
	
	
}
