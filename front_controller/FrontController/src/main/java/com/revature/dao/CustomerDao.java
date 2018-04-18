package com.revature.dao;

import java.util.List;

import com.revature.model.Customer;

/* Contract interface that uses DAO design pattern rules that can be implemented
 * by many types of technologies like JDBC, Hibernate, MongoDB, etc.
 */
public interface CustomerDao {
	public boolean insert(Customer customer);
	public boolean insertProcedure(Customer customer);
	public Customer select(Customer customer);
	public List<Customer> selectAll();
	public String getCustomerHash(Customer customer);
}
