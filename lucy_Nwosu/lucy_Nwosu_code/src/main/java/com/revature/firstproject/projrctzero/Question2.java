package com.revature.projrctzero;

import java.util.*;
public class Question2 {

//Write a program to search for the greatest of three numbers using Short-circuit Operators and print the result
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x, y, z;
	      System.out.println("Enter three numbers ");
	      Scanner in = new Scanner(System.in);
	 
	      x = in.nextInt();
	      y = in.nextInt();
	      z = in.nextInt();
		
		//Condition for finding the max number
		
		if (x>y && x>z) {
			System.out.println("X is largest");
		}
		
		else if (y>z) {
			System.out.println("Y is largest");
		}
		else {
			System.out.println("Z is largest");
		}
	}

}
