package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {
	public boolean insertEmployee(Employee inputEmployee);
	public Employee getEmployee(String username, String password);
	public boolean updateEmployee(Employee inputEmployee);
	public List<Employee> getAllEmployee();
}
