package main.Dao;

import java.util.List;

import main.Model.Employee;

public interface EmployeeDao 
{
	public boolean insertEmployee(Employee e);
	public Employee getEmployee(String email);
	public boolean updateEmployee(Employee e);
	public List<Employee> getAllEmployees();
}
