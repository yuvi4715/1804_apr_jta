package com.revature.classmembers;

public class CustomerApp {
	public static void main(String[] args) {
		Customer customer1 = new Customer();
		Customer customer2 = new Customer("Matt", "Murdoch");
		
		System.out.println(customer1.greeting());
		System.out.println(customer1.greeting("Nelson"));
		
		System.out.println(customer1.getCustomerCount());
		System.out.println(customer1.getCustomerCount(false));

		System.out.println(customer2.greeting());
		System.out.println(customer2.greeting("Karen"));
		
		System.out.println(customer2.getCustomerCount());
		System.out.println(customer2.getCustomerCount(true));
		
		System.out.println(Customer.customerCount);
		
		System.out.println(Customer.makeEmptyCustomer());
		System.out.println(Customer.customerCount);

		System.out.println(Customer.numberOfNonEmptyCustomers());
		
	}
}
