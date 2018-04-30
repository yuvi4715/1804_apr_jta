package com.revature.dao;

import java.sql.Blob;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDao {
	public boolean insertEmployee(Employee employee);
	public Employee getEmployee(String username);
	public String getEmployeePassword(String username);
	public List<String> getAllUsernames();
	public boolean updatePassword(String username, String password);
	public List<Employee> getAllEmployees();
	public boolean updateEmploymentStatus(String username, boolean status);
	public boolean updateEmployee(Employee employee);
	public boolean updateImage(int requestId, Blob image);
}
