package com.revature.projzeroQtn10To15;

public class Tester {


	//Implementation of try -catch block
	//Code to copy
	//Tester.java
		
		   public static void main(String[] args) {
		      
		       double numerator=10;
		       int denominator=0;
		      
		       //try-catch block
		       try {
		          
		           System.out.println("Starting try block");
		           //Check if denominator is 0
		           //then throws custom exception
		           if(denominator==0)
		               throw new CustomDivideByZero("Custome Exception : Cannot divide by 0");
		          
		           //This will not run
		           double result=numerator/denominator;
		          
		          
		           System.out.println("result = "+result);
		           System.out.println("Ending try block");
		          
		          
		       } catch (CustomDivideByZero e) {
		           //catch block
		           System.out.println("Starting catch block");
		           System.out.println(e.getMessage());
		           System.out.println("Ending catch block");
		       }
		       finally
		       {
		           //finally block
		           System.out.println("finally ,good bye!.");
		       }      
		   }
		}//end of the class

