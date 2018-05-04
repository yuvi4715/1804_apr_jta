package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ajax.AjaxMessage;
import com.revature.model.Customer;
import com.revature.service.CustomerService;
import com.revature.util.FinalUtil;

/* AJAX controller that checks if specific username is taken */
public class CheckUsernameController {
	
	public static Object checkUsername(HttpServletRequest request, HttpServletResponse response) {
		
		if(CustomerService.getCustomerService().isUsernameTaken(new Customer(
				request.getParameter("username")))) {
			return new AjaxMessage(FinalUtil.USERNAME_TAKEN);
		}
		else {
			return new AjaxMessage(FinalUtil.USERNAME_AVAILABLE);
		}
	}
}
