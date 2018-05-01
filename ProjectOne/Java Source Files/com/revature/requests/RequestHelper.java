package com.revature.requests;

import javax.servlet.http.HttpServletRequest;

import com.revature.service.UserService;


public class RequestHelper {
	FrontController t = new FrontController();
	
	public static Object process(HttpServletRequest req) {
		switch (req.getRequestURI()) {
		case "/ProjectOne/show.do" :
			return UserService.getUser(req.getParameter("username"), req.getParameter("password"));
		case "/ProjectOne/position.do" :
			return UserService.isManager(req.getParameter("email"));
		case "/ProjectOne/showAllUsers.do" :
			return UserService.getAllUsers();
		case "/ProjectOne/update.do" :
			return UserService.updateUser(req.getParameter("email"), req.getParameter("firstName"), 
					req.getParameter("lastName"), req.getParameter("password"));
		case "/ProjectOne/submit.do" :
			return UserService.submitRequest(req.getParameter("email"), 
					Integer.parseInt(req.getParameter("amount")), req.getParameter("purpose"));
		case "/ProjectOne/pending.do" :
			return UserService.getPendingRequests(req.getParameter("email"));
		case "/ProjectOne/myResolved.do" :
			return UserService.getResolvedRequests(req.getParameter("email"));
		case "/ProjectOne/allPending.do" :
			return UserService.getAllPendingRequests();
		case "/ProjectOne/allResolved.do" :
			return UserService.getAllResolvedRequests();
		case "/ProjectOne/allRequests.do" :
			return UserService.getAllRequests();	
		case "/ProjectOne/employeeRequests.do" :
			return UserService.getEmployeeRequests(req.getParameter("email"));
		case "/ProjectOne/respondToRequest.do" :
			return UserService.respondToRequest((req.getParameter("email")),Integer.parseInt(req.getParameter("amount")),
					req.getParameter("requester"), req.getParameter("response"));
		default:
			return null;
			
		
		}
	}
}
