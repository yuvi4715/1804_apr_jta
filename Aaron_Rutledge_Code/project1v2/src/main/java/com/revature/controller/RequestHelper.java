package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.LoginController;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {
	
	public static String process(HttpServletRequest request) {
		
		
		String controlString;
		
		switch(request.getRequestURI()) {
		case "/project1v2/login.do":
			controlString = LoginController.login(request);
			break;
		case "/project1v2/submit.do":
			controlString = ReimbursementController.submit(request);
			break;
		case "/project1v2/displayEmployees.do":
			controlString = EmployeeController.displayAll(request);
			break;
		case "/project1v2/getMy.do":
			controlString = EmployeeController.display(request);
			break;
		case "/project1v2/updateEmployee.do":
			controlString = EmployeeController.update(request);
			break;
		case "/project1v2/approve.do": 
			controlString = ReimbursementController.approve(request);
			break;
		case "/project1v2/deny.do": 
			controlString = ReimbursementController.deny(request);
			break;
		case "/project1v2/displayAll.do": 
			controlString = ReimbursementController.displayAll(request);
			break;
		case "/project1v2/displayMine.do": 
 			controlString = ReimbursementController.displayMine(request);
			break;
		case "/project1v2/displayPending.do": 
			controlString = ReimbursementController.displayPending(request);
			break;
		case "/project1v2/displayApproved.do":
			controlString = ReimbursementController.displayApproved(request);
			break;
		case "/project1v2/displayDenied.do": 
			controlString = ReimbursementController.displayDenied(request);
			break;
		case "/project1v2/logout.do":
			controlString = LoginController.logout(request);
			break;
		
			
		default:
			return "404.html";
		}
		
		
		
		return controlString;
		
	}
}