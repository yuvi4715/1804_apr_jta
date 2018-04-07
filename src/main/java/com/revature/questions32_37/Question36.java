package com.revature.questions32_37;

import java.util.Scanner;

public class Question36 {

	public static void main(String[] args) {
		
		Arithmetic();
	}
	
	
	static void Arithmetic() {
		
		@SuppressWarnings("resource")
		Scanner askUser = new Scanner(System.in);
		
		System.out.println("Enter first Integer: ");
		int int1 = Integer.valueOf(askUser.nextLine());
		
		System.out.println("Enter second Integer: ");
		int int2 = Integer.valueOf(askUser.nextLine());
		
		System.out.println("Enter Arithmetic Operator: ");
		char operator = askUser.nextLine().charAt(0);
		
		if(operator == '+'){
			System.out.println(int1 + " + " + int2 + " = " + (int1+int2));	
			
		}else if(operator == '-') {
			System.out.println(int1 + " - " + int2 + " = " + (int1-int2));	
			
		}else if(operator == '*') {
			System.out.println(int1 + " * " + int2 + " = " + (int1*int2));	
			
		}else if(operator == '/') {
			System.out.println(int1 + " / " + int2 + " = " + (int1/int2) + " (Does not take into account remainder.)");	
			
		}else {
			System.out.println("Invalid Operator");
		}
		
		
		
	
	}
}
