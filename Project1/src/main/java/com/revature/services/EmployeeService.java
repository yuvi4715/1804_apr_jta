package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.model.Employee;


public class EmployeeService 
{
	public static EmployeeDAO dao = new EmployeeDAOImpl();

	public static boolean insertEmployee(Employee em)
	{
		return dao.insertEmployee(em);
	}
	
	public static Employee getEmployee(String username )
	{
		return dao.getEmployee(username);
	}
	
	public static List<Employee> getAllEmployee()
	{
		return dao.getAllEmployee();
	}
	public static boolean updateManager(Employee em)
	{
		return dao.updateManager(em);
	}
	
	public static boolean updateUserInformation(Employee em)
	{
		return dao.updateUserInformation(em);
	}
	
	public static boolean deleteUser(String username)
	{
		return dao.deleteUser(username);
	}

}
