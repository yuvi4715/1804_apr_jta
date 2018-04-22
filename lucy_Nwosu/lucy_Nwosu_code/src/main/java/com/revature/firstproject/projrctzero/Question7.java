package com.revature.projrctzero;

public class Question7
{

	public static void main(String[] args) {
		// TODO Auto-generated method
		
		
		
		//Create a Customer class with:
			//At least 2 constructors
			//At least 2 overloaded methods
			//At least 1 static variable
			//At least 2 static methods
			//At least 1 final variable
		
		//integer i = new integer();
		//if (i==0) System.out.println("=");
		//if (i!=0) System.out.println("!");
		//if (i>0) System.out.println(">");
		//if (i<0) System.out.println("<");	

		CustomerWithConstructor customername = new CustomerWithConstructor("Lucy");
		CustomerWithConstructor customerid = new CustomerWithConstructor(20);
		
			
		System.out.println("Customer name is: "+ customername.getName() +" " + "and" + " " + "Customer ID is: " + customerid.getId());
		
	}

}
