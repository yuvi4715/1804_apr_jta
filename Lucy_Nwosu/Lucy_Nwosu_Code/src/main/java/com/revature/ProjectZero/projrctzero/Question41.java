package com.revature.projrctzero;

public class Question41 {

//	Write a Java program that prints the numbers from 1 to 50. 
//	But for multiples of three print "Fizz" instead of the number and for the multiples of five print "Buzz". 
//	For numbers which are multiples of both three and five print "FizzBuzz"
	

	   public static void main(String[] args) {
	       int num;
	       int MAX=50;
	      
	       /**Run for loop from 1 to 50*/
	       for (num = 1; num <=MAX; num++)
	       {
	           //check if start num is multiple of 3
	               if(num%3==0)
	                   System.out.printf("Fizz\n");
	               //check if start num is multiple of 5
	               else if(num%5==0)
	                   System.out.printf("Buzz\n");
	               //check if start num is multiple of 3 and 5
	               else if(num%3==0 && num%5==0)
	                   System.out.printf("FizzBuzz\n");
	               else
	                   System.out.printf("%d\n",num);
					   
		                  
	       }
	   }


	
}

