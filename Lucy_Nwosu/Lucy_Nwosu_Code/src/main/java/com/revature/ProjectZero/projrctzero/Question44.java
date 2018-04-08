package com.revature.projrctzero;

import java.util.Scanner;

public class Question44 {

	//Question: Using Java Write a method to reverse a String without using API functions. 



//	Write a method to reverse a String without using API functions.
//	Expert Answer 

    
	    public static void main(String[] args){
	        
	        Scanner scan = new Scanner(System.in);
	        
	        System.out.print("Enter String to Reverse: ");
	        String inpString = scan.nextLine();
	        String outString = "";
	        int length = inpString.length();
	        for(int i=length-1;i>=0;i--){
	            outString+=inpString.charAt(i);
	        }
	        System.out.println("Reversed String: " + outString);
	    } 
	}
//	Scanner is used to read input
//	String reversed by accessing the string from the end by using the length of the string until start of the string



