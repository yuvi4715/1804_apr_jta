package com.revature.servlet;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.service.EmployeeService;
import com.revature.service.RequestService;

public class RequestHelper {
	private static Employee employee;
	
	public static String processString(HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		
		case "/ersProject1/html/login.do":
			return login(req);
		case "/ersProject1/html/SignUp.do": 
			signUp(req);
			return "login.html";
		
		default: return ("404 not found!");
		
		}
	}
	
	public static Object processRequestObject(HttpServletRequest req) {
		System.out.println("Process Request Object URI: " + req.getRequestURI());
		List<Request> employeeOpenRequests = RequestService.getRequestsByRequesterUsername(employee.getUserName());
		//TODO probably change these so that they will match the actual uri once called
		switch (req.getRequestURI()) {
		case "/ersProject1/html/EmployeeHomeRequest.do":
			System.out.println("We are here");
			List<Object> employeeInfo = new ArrayList<Object>();
			employeeInfo.add(employee);
			return employeeInfo;
		
		case "/ersProject1/html/OpenUserRequests.do":
			List<Object> userRequests  = new ArrayList<Object>();
			for(int i = 0;i<employeeOpenRequests.size();i++) {
				userRequests.add(employeeOpenRequests.get(i));
			}
			return userRequests;
		case "/ersProject1/html/OpenSpecificUserRequests.do":
			System.out.println("Inside specific user");
			List<Request> specificRequest = RequestService.getRequestsByRequesterUsername(req.getParameter("username"));

			System.out.println(specificRequest);
			List<Object> specificRequests  = new ArrayList<Object>();
			for(int i = 0;i<specificRequest.size();i++) {
				specificRequests.add(specificRequest.get(i));
			}
			return specificRequests;
		case "/ersProject1/html/AllPendingRequests.do" :
			System.out.println("in all pending requests");
			List<Request> pendingRequests = RequestService.getAllPendingRequests();
			List<Object> allPendingRequests = new ArrayList<Object>();
			for(int i=0;i<pendingRequests.size();i++) {
				allPendingRequests.add(pendingRequests.get(i));
			}
			System.out.println(pendingRequests.toString());
			return pendingRequests;
		case "/ersProject1/html/AllApprovedRequests.do" :
			List<Request> approvedRequests = RequestService.getAllApprovedRequests();
			List<Object> allApprovedRequests = new ArrayList<Object>();
			for(int i=0;i<approvedRequests.size();i++) {
				allApprovedRequests.add(approvedRequests.get(i));
			}
			return allApprovedRequests;
			
		case "/ersProject1/html/AllDeniedRequests.do" :
			List<Request> deniedRequests = RequestService.getAllDeniedRequests();
			List<Object> allDeniedRequests = new ArrayList<Object>();
			for(int i=0;i<deniedRequests.size();i++) {
				allDeniedRequests.add(deniedRequests.get(i));
			}
			return allDeniedRequests;
		case "/ersProject1/html/PendingUserRequests.do" :
			List<Object> userPendingRequests  = new ArrayList<Object>();
			for(int i = 0;i<employeeOpenRequests.size();i++) {
				if(employeeOpenRequests.get(i).getStatusOfRequest().equals("Pending")){
					userPendingRequests.add(employeeOpenRequests.get(i));
				}
			}
			return userPendingRequests;
		case "/ersProject1/html/AllEmployees.do":
			System.out.println("Inside all employees");
			List<Employee> allEmployees = EmployeeService.getAllEmployees();
			List<Object> employees = new ArrayList<Object>();
			for(int i=0;i<allEmployees.size();i++) {
				employees.add(allEmployees.get(i));
			}
			return employees;
		
		case "/ersProject1/html/ApprovedUserRequests.do" :
			List<Object> userApprovedRequests  = new ArrayList<Object>();
			for(int i = 0;i<employeeOpenRequests.size();i++) {
				if(employeeOpenRequests.get(i).getStatusOfRequest().equals("Approved")){
					userApprovedRequests.add(employeeOpenRequests.get(i));
				}
			}
			return userApprovedRequests;
			
		case "/ersProject1/html/DeniedUserRequests.do" :
			List<Object> userDeniedRequests  = new ArrayList<Object>();
			for(int i = 0;i<employeeOpenRequests.size();i++) {
				if(employeeOpenRequests.get(i).getStatusOfRequest().equals("Approved")){
					userDeniedRequests.add(employeeOpenRequests.get(i));
				}
			}
			return userDeniedRequests;
		case "/ersProject1/html/Resolved.do":
			List<Request> r = RequestService.getAllRequests();
			List<Object> o = new ArrayList<Object>();
			for(int i = 0; i<r.size();i++) {
				if (r.get(i).getStatusOfRequest().equals("Approved")|| r.get(i).getStatusOfRequest().equals("Denied")){
					o.add(r.get(i));
				}
			}
			return o;
		case "/ersProject1/html/UpdateEmployeeInfo.do":
			updateEmployeeInfo(req);
			return null;
		case "/ersProject1/html/ApproveOrDenyRequest.do":
			approveOrDenyRequest(req);
			return null;
		case "/ersProject1/html/SubmitRequest.do" :
			submitRequest(req);
			return null;
		default: System.out.println("This is in the default");
		return null;
		}
	}
	
	public static void approveOrDenyRequest(HttpServletRequest req) {
		System.out.println("got inside approve or deny request");
		RequestService.updateReviewed(Integer.parseInt(req.getParameter("RequestId")), req.getParameter("Status"), employee.getEmployeeId());
	}
	
	public static void submitRequest(HttpServletRequest req) {
		System.out.println("Inside submit request");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println(req.getParameter("amount"));
		System.out.println(req.getParameter("purpose"));
		RequestService.insertIntoRequest(new Request(0,Double.parseDouble(req.getParameter("amount")),employee.getEmployeeId(),1,"Pending",req.getParameter("purpose"),ts,ts));
	}
	
	public static void updateEmployeeInfo(HttpServletRequest req) {
		EmployeeService.updateEmployee(new Employee(0,req.getParameter("email"),req.getParameter("username"),
				req.getParameter("password"),req.getParameter("firstName"), req.getParameter("lastName"),
				req.getParameter("manager").equals("manager"), true));
	}
	
	public static void signUp(HttpServletRequest req) {
		System.out.println("in signup.do");
		System.out.println(req.getParameter("email"));
		EmployeeService.insertEmployee(new Employee(0,req.getParameter("email"),req.getParameter("username"),
				req.getParameter("password"),req.getParameter("firstName"), req.getParameter("lastName"),
				false, true));
	}
	
	public static String login(HttpServletRequest req) {
		System.out.println("Made it into login");
		System.out.println(req.getParameter("username"));
		System.out.println(EmployeeService.getEmployeePassword(req.getParameter("username")));
		System.out.println(req.getParameter("password"));
		System.out.println(EmployeeService.getAllUsernames());
		if(EmployeeService.getEmployeePassword(req.getParameter("username")).equals(req.getParameter("password"))
				&& EmployeeService.getAllUsernames().contains(req.getParameter("username"))) {
			System.out.println("Username and password are correct");
			employee = EmployeeService.getEmployee(req.getParameter("username"));
			if(employee.getEmploymentStatus() && employee.getManagerStatus()){
				return "/ersProject1/html/ManagerHomepage.html";
			}
			else if(employee.getEmploymentStatus() && !(employee.getManagerStatus())) {
				return "/ersProject1/html/EmployeeHomepage.html";
			}
			else {
				return "/ersProject1/html/NoLongerEmployee.html";
			}
		}
		return "/ersProject1/html/NotSignedUp";
	}
}
