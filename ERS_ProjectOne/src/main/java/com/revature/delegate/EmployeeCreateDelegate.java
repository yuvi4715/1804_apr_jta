package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;
import com.revature.util.LoggingUtil;

public class EmployeeCreateDelegate {
	final static Logger log = Logger.getLogger(LoggingUtil.class);
	public EmployeeDao ed = new EmployeeDaoJdbc();
	public void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String userName = request.getParameter("userName");
	Employee inputEmployee = new Employee(email, password, firstName, lastName, userName);
	ed.insertEmployee(inputEmployee);
	PrintWriter pw = response.getWriter();
	pw.println("You have successfully created a new employee account.");
	log.info("A new account has been created by a manager: " + inputEmployee.getUserName());
	}
}
