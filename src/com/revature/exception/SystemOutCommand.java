package com.revature.exception;

public class SystemOutCommand {
	
static void add(int a, int b) {
		
		try{
			int z = a/b;
			System.out.println("The result is " + z);
			System.exit(0);
		}catch (ArithmeticException ae) {
			System.out.println("Finally block will not be executed");
			System.exit(0);
			
		}finally {
			System.out.println("Thanks for using the application");
		}
		
	}

	public static void main(String[] args) {
		
		add(5,0);
	}

}
