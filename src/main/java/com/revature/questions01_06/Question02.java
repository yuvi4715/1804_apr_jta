package com.revature.questions01_06;

public class Question02 {

	public static void main(String[] args) {
		
		greatest_number(4, 5, 7);
		greatest_number(7, 100, 8);
		greatest_number(999, 999, 999);
	}
	
	public static void greatest_number(double a, double b, double c) {
		
		double biggest;
        if( a>b && a> c)
        	biggest = a;
        else if(b>a && b>c)
        	biggest = b;
        else
        	biggest = c;
         
        System.out.println("Greatest of three numbers: "+ biggest);
	}
}
