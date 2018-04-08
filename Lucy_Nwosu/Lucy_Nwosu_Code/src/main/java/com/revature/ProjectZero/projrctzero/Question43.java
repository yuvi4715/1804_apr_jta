package com.revature.projrctzero;

import java.util.Scanner;

public class Question43 {
	
	//Write a Java program to check if a number is Armstrong or not.
	
	// Armstrong number is a number that is equal to the sum of cubes of its digits for example 0, 1, 153, 370, 371, 407 etc.


public static void main(String[] args)
	        {
	            int num, count = 0, a, b, c, sum = 0;
	            Scanner s = new Scanner(System.in);
	            System.out.print("Enter Number You want to Check is Armstrong Or not ? :");
	            num = s.nextInt();      //taking input and storinhg into num varible
	            a = num;                //copying input value in "a" to perform operation
	            c = num;          
	            while(a > 0)                    
	            {
	                a = a / 10;
	                count++;
	              
	            }
	            while(num > 0)
	            {
	                b = num % 10;
	                sum = (int) (sum+Math.pow(b, count));
	                num = num / 10;
	              
	            }
	            if(sum == c)                                     // here checking number is armstrong
	            {
	                System.out.println(c + " is Armstrong Number");
	              
	            }
	            else
	            {
	                System.out.println(c + " is not Armstrong Number");
	                }
	                }
	      
	    }
		
		