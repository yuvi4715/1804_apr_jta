package com.ranieri.servlet;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranieri.controller.EmployeeController;
import com.ranieri.controller.ManagerController;
import com.ranieri.controller.ReimbursementController;
import com.ranieri.model.Employee;
import com.ranieri.service.EmployeeService;

public class RequestHelper {
	
	
	
public static String process(HttpServletRequest req) {
		
		switch (req.getRequestURI()) {
		case "/reimbursement/login.do":
			return  EmployeeController.getEmployee(req);
			
		case "/reimbursement/manager.do":
			return ManagerController.updateReimbursement(req);
		
		case "/reimbursement/getAllReimbursements.do":
			return ManagerController.showAllRemibursemets(req);
		
		case "/reimbursement/createRequest.do":
			return ReimbursementController.doRequest(req);
			
		default:
				return "unable to reach database";
		
		}
		


}
}