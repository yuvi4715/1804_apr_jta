package com.revature.questions07_08;

public class Customer {


	public static String customerOf = "I ate at Adam's pizzaria!";
	public String name = "Joe";
	public String foodEaten = "Pizza";
	public int customerID = 100;
	public boolean isHuman;
	public boolean isHungry;
	public String topping = "Plain";
	public String crust = "Flour";
	public String milkShake = "None";
	public String pizza = "None";
	
	public Customer() {
		this.isHuman = true;
		this.isHungry = false;
	}
	
	
	public static void createPizza(String...x) {
		
		StringBuilder toppings = new StringBuilder("");
		
		for(int i = 0; i < x.length; i++) {
			toppings.append(x[i]);
			toppings.append(" YOHOHO! "); //just flavor text
		}
			toppings.append("HUMAN");
		System.out.println("Your pizza at Adam's pizzaria has the toppings: " + toppings);
	}
	
	public void pizzaType(String topping){
		this.topping = topping;
	}
	
	public void pizzaType(String topping, String dough){
		this.topping = topping;
		this.crust = dough;
	}
	
	
	public void makeMilkShake(String iceCream) {
		this.milkShake = iceCream;
	}
	
	public void makeMilkShake(String iceCream, String cookie) {
		String shake = iceCream + " " + cookie;
		
		this.milkShake = shake;
	}
	
	
	
	
	
	
	
}
