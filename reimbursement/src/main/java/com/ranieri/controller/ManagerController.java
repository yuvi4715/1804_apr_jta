package com.ranieri.controller;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranieri.service.EmployeeService;
import com.ranieri.service.RequestService;

public class ManagerController {
	
	
	
	
public static String updateReimbursement(HttpServletRequest req) {
		
		
		RequestService.updateRequest(Integer.parseInt(req.getParameter("id_number")) , req.getParameter("status"), "test manager");
		
		
		return "successfully updated";
			
	}

}
