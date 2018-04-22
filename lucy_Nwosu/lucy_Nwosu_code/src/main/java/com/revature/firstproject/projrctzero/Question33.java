package com.revature.projrctzero;

import java.util.*;

public class Question33 {
	
	static //Write a program called CheckOddEven which prints "Odd Number" if the int variable “number” is odd, or “Even Number” otherwise. Hint: you may use modulus operator.
	//Expert Answer 
	Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		
	
	int n;
	System.out.println("Enter a number: ");
	n=sc.nextInt();
	
	if(n%2==0)
	System.out.println("The number is even ");
	else
	System.out.println("The number is Odd");
	}
	}

