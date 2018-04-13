package com.revature.application;

import java.util.List;

import com.revature.model.Customer;
import com.revature.service.CustomerService;

public class Application {

	public static void main(String[] args) {
//		List<Customer> customers = CustomerService.getAllCustomers();
//		System.out.println("Total Customers: " + customers.size());
//		for (Customer c : customers) {
//			System.out.println(c);
//		}
		
//		Customer julieSmith = CustomerService.getCustomer("emma_jones@hotmail.com");
//		System.out.println(julieSmith);
		
		Customer william = new Customer("William", "Gentry", "william@test.com");
		System.out.println("Insertion was successful: " + CustomerService.insertCustomer(william));
	}
}
