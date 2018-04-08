package com.easycodes.work;

import java.util.Scanner;

public class KeyboardScanner {

	public static void main(String[] args) {

		int x,y;
		String op;
		Scanner input = new Scanner(System.in);
		System.out.println("This program calculates the operation you, the user, give it.");
		System.out.print("Please input one number: ");
		x = input.nextInt();
		
		System.out.print("Please input another number: ");
		y = input.nextInt();
		
		System.out.print("Now input the operation you wish to execute (+, -, *, /): ");
		op = input.next();
		
		input.close();
		
		if(op.equals("+")) {
			System.out.println(x + " + " + y + " = " + (x+y));
		}
		else if(op.equals("-")) {
			System.out.println(x + " - " + y + " = " + (x-y));
		}
		else if(op.equals("*")) {
			System.out.println(x + " * " + y + " = " + (x*y));
		}
		else if(op.equals("/")) {
			System.out.println(x + " / " + y + " = " + (x/y));
		}
		else {
			System.out.println("The selected operator is not one of the mentioned above. Exiting program...");
		}
	}

}
