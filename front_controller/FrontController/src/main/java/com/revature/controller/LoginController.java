package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Customer;
import com.revature.service.CustomerService;
import com.revature.util.FinalUtil;

public class LoginController {
	
	public static String login(HttpServletRequest request) {
		
		//If it's a GET we just return the view.
		if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
			return "login.jsp";
		}
		
		//POST logic
		Customer loggedCustomer = CustomerService.getCustomerService().login(
				new Customer(
						request.getParameter("username"),
						request.getParameter("password")
						));
		
		// Wrong Credentials
		if(loggedCustomer.getUsername().equals("")) {
			return "login.jsp";
		}
		else {
			/* Storing loggedCustomer to current session
			SESSION SCOPE IS AVAILABLE ONLY IN THIS REQUEST (CLIENT) */
			request.getSession().setAttribute("loggedCustomer", loggedCustomer);
			
			//Forward user to hit another controller
			return "/home.do";
		}
	}
}
