package com.revature.service;

import com.revature.model.Employee;
import com.revature.dao.TemplateDao;
import com.revature.dao.EmployeeDao;
import java.util.List;


public class EmployeeService {
	
	private static TemplateDao<Employee, Integer> dao = new EmployeeDao();
	
	private EmployeeService() {}
	
	public static Employee login(String email, String pass) {
		return dao.login(email, pass);
	}
	
	public static Employee get(Integer id) {
		
		return dao.get(id);
	}
	
	public static List<Employee> getAll() {
		
		return dao.getAll();
	}
	
	public static boolean update(Employee t) {
		
		return dao.update(t);
		
	}
	
	public static boolean updateEmail(Employee t) {
		
		return dao.updateEmail(t);
	}
	
//	public static void main(String[] args) {
//		
//		
//		
//		Employee emp = EmployeeService.login("rainbows@sunshine.com", "ummmmm");
//		
//		System.out.println(emp.getfName());
//		
//	}
	
	

}
