package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.service.SupervisorService;

public class LoginController {
	
	public static String login(HttpServletRequest request) {
		
		request.setAttribute("redirectFlag", new Integer(1));
		
		//If it's a GET we just return the view.
		if(request.getMethod().equals("GET")) {
			//System.out.println("in Get");
			return "html/login.html";
		}
		
		//POST logic
		boolean isManager = false;
		isManager = Boolean.parseBoolean(request.getParameter("isManager"));
		
		//System.out.println(request.getParameter("isManager"));
		Employee loggedEmployee;
		if (isManager) {
			//System.out.println("isManager is true");
			loggedEmployee = SupervisorService.login(
								request.getParameter("userEmail"),
								request.getParameter("userPass")
								);
		}
		else {
			//System.out.println("isManager is false");
			loggedEmployee = EmployeeService.login(
								request.getParameter("userEmail"),
								request.getParameter("userPass")
								);
		}
		//System.out.println(loggedEmployee.getStatus());
		// Wrong Credentials
		if(loggedEmployee.getStatus() != 1 && loggedEmployee.getStatus() != 3) {
			
			return "html/login.html";
		}
		else {
			/* Storing loggedCustomer to current session
			SESSION SCOPE IS AVAILABLE ONLY IN THIS REQUEST (CLIENT) */
			HttpSession session = request.getSession();
			session.setAttribute("userid",loggedEmployee.getUserid());
			session.setAttribute("fName",loggedEmployee.getfName());
			session.setAttribute("lName",loggedEmployee.getlName());
			session.setAttribute("email",loggedEmployee.getEmail());
			
		}
		if (isManager) {
			return "html/managerMenu.html";
		} else {
			return "html/employeeMenu.html";
		}
	}
	public static String logout(HttpServletRequest request) { 
		//TODO
		request.getSession().invalidate();
		return "html/login.html";
	}
	
}