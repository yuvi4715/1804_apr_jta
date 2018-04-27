package com.ranieri.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ranieri.model.Request;
import com.ranieri.service.RequestService;

public class ReimbursementController {
	
	
	
public static String doRequest(HttpServletRequest req) {
	
	
	String email = req.getParameter("email");
	String reason = req.getParameter("reason");
	String amount = req.getParameter("amount");
	String image = req.getParameter("image");
	
	System.out.println("before the create");
	RequestService.createRequest(email, reason, Double.parseDouble(amount), image);
	System.out.println("after the create");
	
	
	return "created request";
	
}

public static String getEmployeeReimbursemt(HttpServletRequest req) {
	
	List<Request> list = RequestService.getAllRequests();
	String email = req.getParameter("email");
	String data ="";
	for(Request x : list) {
		
		if(x.getEmail().equals(email)){
		data= data +x +"\n";
		}
		
	}
	
	return data;
}
	
	
	
	
	public static void main(String[] args) {
				
//		String test = ReimbursementController.getEmployeeReimbursemt("bruce@wayne.com");		
//		System.out.println(test);
//		ReimbursementController.doRequest("kim@wayne.com", "mod pizza", "180", "cracked screen");	
		
	}

}
