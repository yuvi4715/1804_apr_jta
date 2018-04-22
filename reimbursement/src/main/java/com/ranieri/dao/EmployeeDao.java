package com.ranieri.dao;

import com.ranieri.model.*;

public interface EmployeeDao {
	
	public Employee getEmployee(String email, String password);
	
}
