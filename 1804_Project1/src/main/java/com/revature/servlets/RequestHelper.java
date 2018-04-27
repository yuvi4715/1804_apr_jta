package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.service.EmployeeService;

public class RequestHelper {

public static Object process(HttpServletRequest req) {
				
		switch (req.getRequestURI()) {
			case "/1804_Project1/login.do": 
					return EmployeeService.login(req.getParameter("email"), req.getParameter("pass"));
			default:
				return null;
		}
	}
}
