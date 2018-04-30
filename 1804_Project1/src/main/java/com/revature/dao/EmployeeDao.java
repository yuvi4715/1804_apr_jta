package com.revature.dao;

import com.revature.model.Employee;

public interface EmployeeDao {
	
	public Employee login(String email, String pass);
	public Employee managerLogin(String email, String pass);
}
