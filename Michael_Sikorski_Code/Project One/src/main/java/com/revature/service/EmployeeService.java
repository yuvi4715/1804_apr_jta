/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDAOImplement;
import com.revature.model.*;

public class EmployeeService {

	private static EmployeeService employeeService;

	private EmployeeService() {
	}

	public static EmployeeService getEmployeeService() {
		if (employeeService == null) {
			employeeService = new EmployeeService();
		}
		return employeeService;
	}
	
	public Employee getEmployee(String email) {
		return EmployeeDAOImplement.getInstance().getEmployee(email);
	}
	
	public List<Employee> getAllEmployees() {
		return EmployeeDAOImplement.getInstance().getAllEmployees();
	}
	
	public boolean updateEmployee(String email, String newUsername, String newFirst, String newLast) {
		return EmployeeDAOImplement.getInstance().updateEmployee(email, newUsername, newFirst, newLast);
	}
	
	public boolean createNewEmployee(String email, String username, String password, String first, String last) {
		return EmployeeDAOImplement.getInstance().createNewEmployee(email, username, password, first, last);
	}

}
