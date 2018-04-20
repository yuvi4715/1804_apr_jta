package com.ranieri.dao;

import com.ranieri.employee.*;

public interface EmployeeDao {
	
	public Employee getEmployee(String email, String password);
	
}
