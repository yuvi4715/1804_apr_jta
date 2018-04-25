package com.ranieri.login;

import com.ranieri.model.Employee;
import com.ranieri.service.EmployeeService;

public class MainLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(employeeInformation());
		
	}
	
	public static int someInt() {
		return 9;
	}
	
	public static String employeeInformation() {
		Employee test = EmployeeService.getEmployee("tester@test.com", "test");
		
		return test.getEmail();
	}

}
