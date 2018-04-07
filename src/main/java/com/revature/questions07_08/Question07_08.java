package com.revature.questions07_08;

public class Question07_08 {
	
	public static void main(String[] args) {
		
		Customer bob = new Customer();
		System.out.println(bob.customerID);
		
		
		bob.pizzaType("Pepperonni");
		System.out.println(bob.topping);
		
		bob.pizzaType("Beef", "Deep Dish");
		System.out.println(bob.topping + " " + bob.crust);
		
		bob.makeMilkShake("vanilla");
		System.out.println(bob.milkShake);
		
		bob.makeMilkShake("chocolate", "oreo");
		System.out.println(bob.milkShake);
		
		Customer.createPizza("beef", "cheese", "jalapeno", "pineapple");
	}
	
	
}
