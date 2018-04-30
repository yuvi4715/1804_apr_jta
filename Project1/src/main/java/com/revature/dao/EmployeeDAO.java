package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;


public interface EmployeeDAO 
{
	public boolean insertEmployee(Employee em);	// Create
	public Employee getEmployee(String username );	// Read
	public List<Employee> getAllEmployee();		// Read
	public boolean updateManager(Employee em);	// Update
	public boolean updateUserInformation(Employee em);  // Update
	public boolean deleteUser(String username); // Delete
}
