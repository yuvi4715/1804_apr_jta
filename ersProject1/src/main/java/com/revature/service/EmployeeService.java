package com.revature.service;

import java.sql.Blob;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;


public class EmployeeService {
	private static EmployeeDao dao = EmployeeDaoImpl.getInstance();
	private static Logger log = Logger.getLogger(RequestService.class);
	
	
	public static boolean insertEmployee(Employee employee) {
		boolean pass = dao.insertEmployee(employee);
		if (pass) log.info("An employee was successfully inserted into the employee table");
		else log.info("An employee was not inserted");
		return pass;
	}
	
	public static Employee getEmployee(String username) {
		return dao.getEmployee(username);
	}
	
	public static String getEmployeePassword(String username) {
		return dao.getEmployeePassword(username);
	}
	
	public static List<String> getAllUsernames() {
		return dao.getAllUsernames();
	}
	
	public static boolean updatePassword(String username, String password) {
		boolean pass = dao.updatePassword(username, password);
		if (pass) log.info("employee password has been updated");
		else log.info("Employee password not updated");
		return pass;
	}
	
	public static List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}
	
	public static boolean updateEmploymentStatus(String username, boolean status) {
		boolean pass = dao.updateEmploymentStatus(username, status);
		if (pass) log.info("Employment status has been updated");
		else log.info("Employment status has not been updated");
		return pass;
	}
	
	public static boolean updateEmployee(Employee employee) {
		boolean pass = dao.updateEmployee(employee);
		if (pass) log.info("Employee fully updated");
		else log.info("Employee was not fully updated");
		return pass;
	}
	
	public static boolean updateImage(int requestId, Blob image) {
		boolean pass = dao.updateImage(requestId, image);
		if (pass) log.info("Image successfully stored");
		else log.info("Image was not stored");
		return pass;
	}
	
}
