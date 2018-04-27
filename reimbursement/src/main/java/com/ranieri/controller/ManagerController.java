package com.ranieri.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranieri.model.Request;
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

public static String showAllRemibursemets(HttpServletRequest req) {
	
	
	List<Request> list = RequestService.getAllRequests();
	
	String data ="";
	for(Request x : list) {	
		data= data +x +"\n";
	}
//	System.out.println(data);
	
	return data;
	
}






}
