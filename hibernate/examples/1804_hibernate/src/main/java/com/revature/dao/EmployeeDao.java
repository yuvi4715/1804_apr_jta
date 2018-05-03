package com.revature.dao;

import com.revature.model.EmployeeAnn;
import com.revature.model.EmployeeXML;

public interface EmployeeDao {

	public void insertEmployee(EmployeeXML emp);
	public void insertEmployeeAnn(EmployeeAnn emp);
}
