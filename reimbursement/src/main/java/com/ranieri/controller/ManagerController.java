package com.ranieri.controller;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranieri.service.EmployeeService;
import com.ranieri.service.RequestService;

public class ManagerController {
	
	
	
	
public static String updateReimbursement(HttpServletRequest req) {
		
		System.out.println("the ajax made it this far thank god!!");
		System.out.println(req.getParameter("ID"));
		//RequestService.updateRequest(Integer.parseInt(req.getParameter("id_number")) , req.getParameter("status"), "test manager");
		
		
		return "successfully updated";
			
	}

}
