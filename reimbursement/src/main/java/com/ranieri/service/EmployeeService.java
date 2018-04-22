package com.ranieri.service;

import com.ranieri.dao.EmployeeDao;
import com.ranieri.dao.EmployeeDaoImpl;
import com.ranieri.model.Employee;

public class EmployeeService {

	
	public static EmployeeDao dao = EmployeeDaoImpl.getInstance();
	
	private EmployeeService() {};
	
	public static Employee getEmployee(String email, String password) {
		return dao.getEmployee(email, password);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Employee test =dao.getEmployee("tester@test.com", "test");
		Employee test2 =dao.getEmployee("bruce@wayne.com", "batman");
		//System.out.println(test);
		System.out.println(test2);
		

	}

}
