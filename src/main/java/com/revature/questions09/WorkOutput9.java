package com.revature.questions09;

import com.revature.questions07_08.Customer;

public class WorkOutput9 {


	public static void main(String[] args) {
	
		Customer guy = new Customer();
		
		System.out.println(guy.toString());
		
		
		Customer.createPizza("chicken", "steak", "cheese", "anchovie");
	}
}
