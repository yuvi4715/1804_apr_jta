package com.revature.projrctzero;

public class Question6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create an example for each control statement.


		int a = 10, b = 20, c= 30;
		
		
		//SELECTION STATEMENTS
	
		//1. if statement
		if (a > b)
			System.out.println("a");
		if (a < b)
			System.out.println("b");
		
		//2.  if-else statement
		if (a > b) {
		System.out.println("a > b");
	} else {
		System.out.println("b < a");
	}
		
		//3. switch statement
		int status = -1;
		if (a > b && a > c) {
			status = 1;
		} else if (b > c) {
			status = 2;
		} else {
			status = 3;
		}
		switch (status) {
		case 1:
			System.out.println("a is the greatest");
			break;
		case 2:
			System.out.println("b is the greatest");
			break;
		case 3:
			System.out.println("c is the greatest");
			
			
	}
	
}

}


