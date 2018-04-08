package com.revature.projrctzero;

import java.util.Scanner;

public class Question34PrintNumberInWord {
	
private static Scanner  sc;

//	Write a program called PrintNumberInWord which prints "ONE", "TWO",... , "NINE", "OTHER"
//	if the int variable "number" is 1, 2,... , 9,
//	or other, respectively. Use (a) a "nested-if" statement; (b) a "switch-case" statement.
//	Expert Answer 

	public static void main(String[] args) {
		
		sc= new Scanner(System.in);
		int a,var;
		for (int b = 0; b<3; b++)
		{
		System.out.println("Enter number to be checked: ");
		
		
	
		a = sc.nextInt();
		
		//a. using Nested-if
		
		if (a==1)
			System.out.println("ONE"); 
		else if (a==2)
			System.out.println("TWO");
		else if (a==3)
			System.out.println("THREE");
		else if (a==4)
			System.out.println("FOUR");
		else if (a==5)
			System.out.println("FIVE");
		else if (a==6)
			System.out.println("SIX");
		else if (a==7)
			System.out.println("SEVEN");
		else if (a==8)
			System.out.println("EIGHT");
		else if (a==9)
			System.out.println("NINE");
		else
			System.out.println("OTHER");
			
			
		}
		
//b. using the switch
	
		for (int b = 0; b<3; b++)
	System.out.println("Enter the variable for switch ");
	var= sc.nextInt();

	switch(var)
	{
	case 1:System.out.println("ONE");
	break;
	case 2:System.out.println("TWO");
	break;
	case 3:System.out.println("THREE");
	break;
	case 4:System.out.println("FOUR");
	break;
	case 5:System.out.println("FIVE");
	break;   
	case 6:System.out.println("SIX");
	break;
	case 7:System.out.println("SEVEN");
	break;
	case 8:System.out.println("EIGHT");
	break;
	case 9:System.out.println("NINE");
	break;
	  
	default: System.out.println("OTHER");
	break;
	}
	}
	}

	
