package com.revature.projrctzero;

public class Question3 {

	//Write a program –declare two variables a & b and initialize them to true and false respectively. Get the output of the following computations:
	//!a
	//a | b    
	//(!a & b) | (a & !b)

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean a =true;
		boolean b = false;
		boolean c,d,e;
				
		c = !a;
		d= a | b;
		e= (!a & b) | (a & !b);
		
		System.out.println("C is = " +c);
		System.out.println("D is = " +d);
		System.out.println("E is = " +e);
		
				
	}

}
