package com.revature.exception;

import java.util.Scanner;

public class FinallyBlock {
	
	void add(int a, int b) {
		
		try{
			int z = a/b;
			System.out.println("The result is " + z);
		}catch (ArithmeticException ae) {
			
		}finally {
			System.out.println("Thanks for using the application");
		}
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 2 number to perform division");
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		new FinallyBlock().add(a, b);
		
	}

}
