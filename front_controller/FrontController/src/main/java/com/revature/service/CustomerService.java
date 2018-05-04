package com.revature.service;

import java.util.List;

import com.revature.dao.CustomerDaoJdbc;
import com.revature.model.Customer;
import com.revature.util.FinalUtil;

/* Class that executes business logic related to customers */
public class CustomerService {

	/*Singleton transformation of Customer Service object */
	private static CustomerService customerService;
	
	private CustomerService() {
		
	}
	
	public static CustomerService getCustomerService() {
		if(customerService == null) {
			customerService = new CustomerService();
		}
		
		return customerService;
	}
	
	/* Calls the insert method of the DAO */
	public boolean registerCustomer(Customer customer) {
		return CustomerDaoJdbc.getCustomerDaoJdbc().insert(customer);
	}
	
	/* Calls the insert method that uses stored procedure in DAO */
	public boolean registerCustomerSecure(Customer customer) {
		return CustomerDaoJdbc.getCustomerDaoJdbc().insertProcedure(customer);
	}
	
	/* Calls selectAll method of the DAO */
	public List<Customer> listAllUsers() {
		return CustomerDaoJdbc.getCustomerDaoJdbc().selectAll();
	}
	
	/* Calls select method of the DAO by username and performs login logic */
	public Customer login(Customer customer) {
		//Get user information without validating
		Customer loggedCustomer = CustomerDaoJdbc.getCustomerDaoJdbc().select(customer);
		
		/*
		 * loggedCustomer.getPassword() is the hash we have stored.
		 * We compare that against the hash of the user input.
		 * If credentials are correct we return the full Customer information.
		 * Else, we return a blank object.
		 */
		if(loggedCustomer.getPassword().equals(CustomerDaoJdbc.getCustomerDaoJdbc().getCustomerHash(customer))) {
			return loggedCustomer;
		}
		
		return new Customer();
	}
	
	/* Calls the select method of the DAO, if the user returned is empty, then username is not taken. */
	public boolean isUsernameTaken(Customer customer) {
		if(CustomerDaoJdbc.getCustomerDaoJdbc().select(customer).getUsername().equals(FinalUtil.EMPTY_STRING)) {
			return false;
		}
		return true;
	}
}
