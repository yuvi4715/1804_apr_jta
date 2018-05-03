package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.application.Application;
import com.revature.controller.EmployeeController;
import com.revature.controller.ManagerController;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.service.ERSService;

public class RequestHelper {
	final static Logger log = Logger.getLogger(RequestHelper.class);

	public static String process(HttpServletRequest req)// , HttpServletResponse resp
			throws ServletException, IOException {

		
		// configure employee html to use button
		System.out.println("Handling process");
		switch (req.getRequestURI()) {
		case "/expense_reimbursement_service/FrontController/login":
			log.info("Logged in");
			System.out.println("In login case");
			return getUser(req);

		// employee methods
		// employee can logout
		case "/expense_reimbursement_service/FrontController/logout.do":
			System.out.println("In logout");
			log.info("Logged out");
			return EmployeeController.logout(req);
		// employee can submit request
		case "/expense_reimbursement_service/FrontController/submit.do":
			System.out.println("In submit");
			log.info("Employee submit");
			return EmployeeController.submit(req);
		// employee can view pending
		case "/expense_reimbursement_service/FrontController/viewpending.do":
			System.out.println("In view pending");
			
			return EmployeeController.viewPending(req);
		// employee can view resolved
		case "/expense_reimbursement_service/FrontController/viewresolved.do":
			System.out.println("In view resolved");
			return EmployeeController.viewResolved(req);
		// employee can view their info
		case "/expense_reimbursement_service/FrontController/viewempinfo.do":
			System.out.println("In view emp info");
			return EmployeeController.viewEmpInfo(req);
		// employee can update info

		
		case "/expense_reimbursement_service/FrontController/updateinfo.do":
			System.out.println("In update info");
			log.info("Updating employee");
			return EmployeeController.updateInfo(req);

		// manager methods
		// manager can logout
		// manager can approve/deny
		case "/expense_reimbursement_service/FrontController/updaterequest.do":// TODO
			System.out.println("In update request");
			log.info("Handled a request");
			return ManagerController.updateRequest(req);
		// manager can view all pending
		case "/expense_reimbursement_service/FrontController/showpending.do":
			System.out.println("In show pending");
			return ManagerController.showPending(req);
		// manager can view all approved/denied
		case "/expense_reimbursement_service/FrontController/showresolved.do":
			System.out.println("In show resolved");
			return ManagerController.showResolved(req);
		// manager can view all employees
		case "/expense_reimbursement_service/FrontController/showemployees.do":
			System.out.println("In show employees");
			return ManagerController.showEmployees(req);
		// manager can view all requests from one employee
		case "/expense_reimbursement_service/FrontController/showoneemployee.do":
			System.out.println("In show one employee");
			return ManagerController.showOneEmployees(req);
		default:
			return "unable to reach database";
		}

	}

	public static String getUser(HttpServletRequest req) {
		ObjectMapper om = new ObjectMapper();
		String un = req.getParameter("username");
		String pass = req.getParameter("password");

		Employee emp = new Employee();
		Manager mgr = new Manager();

		try {
			System.out.println("in getUser try/catch");
			if (ERSService.findEmployee(un, pass)) {
				emp = ERSService.employeeInfo(un);
				System.out.println(emp.toString());
				String userLoggedin = om.writeValueAsString(emp);

				// set these so our controller can see what kind of object this is
				req.setAttribute("employee", true);
				req.setAttribute("email", emp.getEmail());
				return userLoggedin;
			} else if (ERSService.findManager(un, pass)) {
				mgr = ERSService.managerInfo(un);
				System.out.println(mgr.toString());
				String userLoggedin = om.writeValueAsString(mgr);

				// set these so our controller can see what kind of object this is
				req.setAttribute("employee", false);
				req.setAttribute("email", mgr.getEmail());
				return userLoggedin;

			} else {
				System.out.println("Invalid username/password");
			}

		} catch (JsonProcessingException jpe) {
			jpe.printStackTrace();

		}
		return "Invalid username/password";

	}

}
