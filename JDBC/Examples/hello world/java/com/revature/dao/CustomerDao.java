package com.revature.dao;

import java.util.List;

import com.revature.model.Customer;

public interface CustomerDao {

	// All interface methods are implicitly public and abstract
	// If you don't provide them, the compiler will automatically insert them
	
	boolean insertCustomer(Customer customer);
	public Customer getCustomer(String email);
	public abstract List<Customer> getAllCustomers();
	public boolean updateCustomer(String email, Customer customer);
	public boolean deleteCustomer(String email);
}
