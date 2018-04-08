package com.revature.projrctzero;

//Write a program called CheckPassFail which prints "PASS" if the int variable "mark" is more than or equal to 50; or prints "FAIL" otherwise.

import java.util.Scanner;

public class Question32CheckPassFail {

	
		public static void main (String[] args)   {
		int marks;
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter score: ");
		marks = reader.nextInt();
		  
		if (marks>=50)
		{
		System.out.println("Pass!");
		}
		else
		System.out.println("Fail!");
		}
		  
		}

