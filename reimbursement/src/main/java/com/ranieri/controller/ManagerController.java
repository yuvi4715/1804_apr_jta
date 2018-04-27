package com.ranieri.controller;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranieri.service.EmployeeService;
import com.ranieri.service.RequestService;

public class ManagerController {
	
	
	
	
public static String updateReimbursement(HttpServletRequest req) {
		
//		System.out.println("the ajax made it this far thank god!!");
//		System.out.println(req.getParameter("ID"));
//		System.out.println(req.getParameter("status"));
//		System.out.println(req.getParameter("manager"));
		RequestService.updateRequest(Integer.parseInt(req.getParameter("ID")) , req.getParameter("status"), req.getParameter("manager"));
		
		
		return "successfully updated";
			
	}

}
