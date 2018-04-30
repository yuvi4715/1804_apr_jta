/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.servlets;

import javax.servlet.http.*;
import com.revature.service.*;

public class RequestHelper {

	public static Object process(HttpServletRequest req, HttpServletResponse res) {
		String uri = req.getRequestURI();
		switch (uri) {
		case "/MS_Project_One/loginEmployee.msp1":
			return new LoginEmployeeService().userOnDb(req.getParameter("email"), req.getParameter("password"));
		case "/MS_Project_One/loginManager.msp1":
			return new LoginManagerService().userOnDb(req.getParameter("email"), req.getParameter("password"));
		case "/MS_Project_One/getAllEmployees.msp1":
			return EmployeeService.getEmployeeService().getAllEmployees();
		case "/MS_Project_One/viewAllResolved.msp1":
			return RequestService.getRequestService().getAllResolvedRequests();
		case "/MS_Project_One/viewAllPending.msp1":
			return RequestService.getRequestService().getAllPendingRequests();
		case "/MS_Project_One/submitRequest.msp1":
			return RequestService.getRequestService().submitRequest(req.getParameter("requester"),
					Integer.parseInt(req.getParameter("amount")),req.getParameter("purpose"));
		case "/MS_Project_One/employeeViewPending.msp1":
			return RequestService.getRequestService().getEmployeesPendingRequests(req.getParameter("email"));
		case "/MS_Project_One/employeeViewPast.msp1":
			return RequestService.getRequestService().getEmployeesResolvedRequests(req.getParameter("email"));
		case "/MS_Project_One/employeeViewInfo.msp1":
			return EmployeeService.getEmployeeService().getEmployee(req.getParameter("email"));
		case "/MS_Project_One/employeeUpdateInfo.msp1":
			String email = req.getParameter("email");
			String newUsername = req.getParameter("newUsername");
			String newFirst = req.getParameter("newFirst");
			String newLast = req.getParameter("newLast");
			return EmployeeService.getEmployeeService().updateEmployee(email, newUsername, newFirst, newLast);
		case "/MS_Project_One/approveDeny.msp1":
			return RequestService.getRequestService().resolveRequest(Integer.parseInt(req.getParameter("requestID")), 
					req.getParameter("newStatus"), req.getParameter("reviewedBy"));
		case "/MS_Project_One/getEmployeesPendingRequests.msp1":
			return RequestService.getRequestService().getEmployeesPendingRequests(req.getParameter("email"));
		default:
			return null;
		}
	}

}
