package com.revature.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import dao.Employee;
import dao.Service;

public class RequestHelper {
	public static String process(HttpServletRequest request) {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
		case "/project1/login.do":
			System.out.println("login");
			return login(request);
		case "/project1/signup.do":
			System.out.println("signup");
			return signup(request);
		default:
			System.out.println("default");
			return "404.jsp";
		}
	}
	
	public static Object oprocess(HttpServletRequest request) {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
		case "/project1/html/getAllEmployees.do":
			System.out.println("getting all Employees");
			return getAllEmployees(request);
		case "/project1/html/getRequests.do":
			System.out.println("getting all Requests");
			return getAllRequests(request);
		case "/project1/html/getResolvedRequests.do":
			return getResolvedRequests(request);
		case "/project1/html/getUnresolvedRequests.do":
			return getUnresolvedRequests(request);
		default:
			System.out.println("default");
			return "404.jsp";
		}
	}
	
	public static String signup(HttpServletRequest request) {
		if(request.getParameter("isManager").equals("Manager")) {
			Service.insertEmployee(new Employee(0,request.getParameter("inputFirstName"),request.getParameter("inputLastName"),
					request.getParameter("inputUsername"), request.getParameter("inputPassword"), request.getParameter("inputEmail"), "Manager"));
			return "html/mmainpage.html";
		}
		else {
			Service.insertEmployee(new Employee(0,request.getParameter("inputFirstName"),request.getParameter("inputLastName"),
					request.getParameter("inputUsername"), request.getParameter("inputPassword"), request.getParameter("inputEmail"), "Employee"));
			return "html/emainpage.html";
		}
	}
	
	public static String login(HttpServletRequest request) {
		Employee a =Service.getEmployeeByUsername(request.getParameter("username"));
		if(a!=null) {
			if(a.getPassword().equals(request.getParameter("password"))) {
				if(a.getEmpRole().equals("Manager")) {
					return "html/mmainpage.html";
				}
				else {
					return "html/emainpage.html";
				}
			}
			else {
				return "html/login.html";
			}
		}
		else {
			return "html/login.html";
		}
	}
	
	public static Object getResolvedRequests(HttpServletRequest request) {
		return Service.getResolvedRequests();
	}
	
	public static Object getUnresolvedRequests(HttpServletRequest request) {
		return Service.getUnresolvedRequests();
	}
	
	public static Object getAllRequests(HttpServletRequest request) {
		return Service.getAllRequests();
	}
	
	public static Object getAllEmployees(HttpServletRequest request) {
		return Service.getAllEmployees();
	}
}
