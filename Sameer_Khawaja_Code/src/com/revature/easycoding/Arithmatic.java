package com.revature.easycoding;


//problem 36
import java.util.Scanner;

public class Arithmatic {

	public static void main(String[] args) {
		// get 2 numbers and operation from user
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int a = reader.nextInt();
		System.out.print("Enter a number: ");
		int b = reader.nextInt();
		System.out.print("Enter an arithmetic operator: ");
		String op = reader.next();
		reader.close();
		int result = 0;
		
		//perform operations
		if(op.equals("+")) {
			result =a+b;
			System.out.println(result);
		}else if(op.equals("-")) {
			result =a-b;
			System.out.println(result);
		}if(op.equals("*")) {
			result =a*b;
			System.out.println(result);
		}if(op.equals("/")) {
			result =a/b;
			System.out.println(result);
		}
		
		
		

	}

}
