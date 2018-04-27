package com.revature.service;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class EmployeeService {
	
	private static EmployeeDao dao = EmployeeDaoImpl.getInstance();
	
	public static Employee login(String email, String pass) {
		return dao.login(email, pass);
	}
}
