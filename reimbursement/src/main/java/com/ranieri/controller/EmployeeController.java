package com.ranieri.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranieri.model.Employee;
import com.ranieri.service.EmployeeService;

public class EmployeeController {
	
	public static String getEmployee(HttpServletRequest req) {
		
		ObjectMapper objectmapper = new ObjectMapper();
		
		
		
		try {
			Employee user = EmployeeService.getEmployee(req.getParameter("email"), req.getParameter("psw"));
			String userLoggedin = objectmapper.writeValueAsString(user);

			req.setAttribute("manager",user.getAuthorization());
			req.setAttribute("username", user.getEmail());
			
			return  userLoggedin;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
			
	}
	

}
