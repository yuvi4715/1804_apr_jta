package com.revature;

import com.revature.model.Customer;
import com.revature.service.CustomerService;

/* Welcome to the Java */
public class Main {
	public static void main(String[] args) {
		//Test insert
		System.out.println(CustomerService.getCustomerService().registerCustomer(
				new Customer(0,"Peter","Alagna","petronilo","1234")));

		//Test insert procedure
		System.out.println(CustomerService.getCustomerService().registerCustomerSecure(
				new Customer(0,"Test","Number2","test2","1234")));

		//Test select all
		System.out.println(CustomerService.getCustomerService().listAllUsers());

		//Test login
		System.out.println(CustomerService.getCustomerService().login(
				new Customer("petronilo","1234")));
	}
}
