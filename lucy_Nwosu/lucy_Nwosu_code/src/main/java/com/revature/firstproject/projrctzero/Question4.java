package com.revature.projrctzero;
import java.util.Scanner;

public class Question4 {

			// TODO Auto-generated method stub
//Write a program to add, subtract, multiply and divide two numbers using methods with parameters using only one class.

		 
		 public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
		   
		  System.out.print("Input first number: ");
		  int num1 = in.nextInt();
		   
		  System.out.print("Input second number: ");
		  int num2 = in.nextInt();
		   
		 
		  System.out.println(num1 + " + " + num2 + " = " + 
		  (num1 + num2));
		   
		  System.out.println(num1 + " - " + num2 + " = " + 
		  (num1 - num2));
		   
		  System.out.println(num1 + " x " + num2 + " = " + 
		  (num1 * num2));
		   
		  System.out.println(num1 + " / " + num2 + " = " + 
		  (num1 / num2));
		 
		 		 }
		
	}

