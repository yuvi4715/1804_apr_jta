package com.revature.dao;

import java.util.List;
import com.revature.model.Employee;
import com.revature.model.EmployeeXML;

public interface EmployeeDao {

	public void insertEmployeeXML(EmployeeXML emp);
	public void insertEmployee(Employee emp);
	public void updateEmployee(int id, String name);
	public Employee findEmployeeById(int id);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(int id);
	public void HQLExample(int id);
	public void namedQueriesExample();
	public void getVSLoad(int id);
	public void saveVSPersist();
	public void criteriaExample();
	
}
