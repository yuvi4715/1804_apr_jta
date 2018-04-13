package com.revature.ClassMembers;

public class OOPQuestions {
	
	public static void main(String[] args) {
		Customer c1 = new Customer();
		Customer c2 = new Customer("Nick McComb");
		
		c1.askName();
		c2.askName(22);
		c2.isAlive();
		c2.species();
	}
}
