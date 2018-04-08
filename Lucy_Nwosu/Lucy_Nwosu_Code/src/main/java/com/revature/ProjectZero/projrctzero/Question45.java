package com.revature.projrctzero;


import java.util.*;
import java.io.*;
public class Question45 {

	//Question: Using Java program Write a method to determine if a number is prime. 



	public static void main(String args[])
	{      
	   int number;
	  
	   boolean isprimecheck=true;
	   Scanner scan= new Scanner(System.in);
	   System.out.println("Enter any number:");
	   int input=scan.nextInt(); // here take input from user
	scan.close();
	   for(int i=2;i<=input/2;i++) // check numberis prime or not
	   {
	number=input%i;
	   if(number==0)
	   {
	   isprimecheck=false;
	   break;
	   }
	   }
	   if(isprimecheck)
	   System.out.println(input + " is a prime number");
	   else
	   System.out.println(input + " is not prime number");
	}
	}
	

