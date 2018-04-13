package com.revature.service;

import java.util.List;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.model.Customer;

public class CustomerService {

	private static CustomerDao dao = CustomerDaoImpl.getInstance();
	
	private CustomerService() {}
	
	public static List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}
	
	public static Customer getCustomer(String email) {
		return dao.getCustomer(email);
	}
	
	public static boolean insertCustomer(Customer customer) {
		return dao.insertCustomer(customer);
	}
}
