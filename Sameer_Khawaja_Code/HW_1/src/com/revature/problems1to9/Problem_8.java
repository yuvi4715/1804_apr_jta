package com.revature.problems1to9;

//problem 8
public class Problem_8 {

	public static void main(String[] args) {
		// init
		final int luckyCustomer = 100;
		Customer.setCustomerCounter(98); // assume 98 identified customers have come in by day 2

		// customer 1
		// 99th customer
		Customer customer1 = new Customer("John Banks", 50);
		if (customer1.getName() != "" || customer1.getAge() != -1) { // customer is identified
			Customer.incLuckyCustomer();
			customer1.greet(customer1.getName());
		}else {
			customer1.greet();
		}
		if (Customer.luckyCustomerCounter == luckyCustomer) {
			System.out.println("Congrats, you are the 100th identified customer!");
		}

		// customer 2
		// not counted, counter remains at 99
		Customer customer2 = new Customer();

		if (customer2.getName() != "" || customer2.getAge() != -1) { // customer is identified
			Customer.incLuckyCustomer();customer2.greet(customer2.getName());
		}else {
			customer2.greet();
		}
		if (Customer.luckyCustomerCounter == luckyCustomer) {
			System.out.println("Congrats, you are the 100th identified customer!");
		}

		// customer 3
		// 100th customer
		Customer customer3 = new Customer("Jane Cache", 25);

		if (customer3.getName() != "" || customer3.getAge() != -1) { // customer is identified
			Customer.incLuckyCustomer();customer3.greet(customer3.getName());
		}else {
			customer3.greet();
		}
		if (Customer.luckyCustomerCounter == luckyCustomer) {
			System.out.println("Congrats, you are the 100th identified customer!");
		}

		
		
		
	}

}
