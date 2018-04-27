package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.Employee;
import dao.Request;
import dao.Service;

public class RequestHelper {
	static Employee cur;
	public static String process(HttpServletRequest request) {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
		
		case "/project1/login.do":
			System.out.println("login");
			return login(request);
			
		case "/project1/signup.do":
			System.out.println("signup");
			return signup(request);
			
		case "/project1/msubmitRequest.do":
			System.out.println("msubmit request");
			return msubmitRequest(request);
			
		case "/project1/esubmitRequest.do":
			System.out.println("esubmit request");
			return esubmitRequest(request);
			
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
			
		case "/project1/html/getAllRequests.do":
			System.out.println("getting all Requests");
			return getAllRequests(request);
			
		case "/project1/html/getResolvedRequests.do":
			System.out.println("getResolvedRequests");
			return getResolvedRequests(request);
			
		case "/project1/html/getUnresolvedRequests.do":
			System.out.println("getUnresolvedRequests");
			return getUnresolvedRequests(request);
			
		case "/project1/html/getRequest.do":
			System.out.println("getRequests");
			return getRequests(request);
			
		case "/project1/html/getInfo.do":
			System.out.println("getInfo");
			return getInfo(request);
			
		case "/project1/html/approveRequest.do":
			System.out.println("approving request");
			return approveRequest(request);
		
		case "/project1/html/getAllMyRequests.do":
			System.out.println("get all my requests");
			return getAllMyRequests(request);
			
		default:
			System.out.println("default");
			return "404.jsp";
		}
	}
	
	public static String msubmitRequest(HttpServletRequest request) {
		Service.insertRequest(new Request(Integer.parseInt(request.getParameter("ammount")),cur.getEmpId(),request.getParameter("purpose")));
		return "html/mmainpage.html";
	}
	
	public static String esubmitRequest(HttpServletRequest request) {
		Service.insertRequest(new Request(Integer.parseInt(request.getParameter("ammount")),cur.getEmpId(),request.getParameter("purpose")));
		return "html/emainpage.html";
	}
	
	public static String signup(HttpServletRequest request) {
		if(request.getParameterMap().containsKey("isManager")) {
			cur=new Employee(0,request.getParameter("inputFirstName"),request.getParameter("inputLastName"),
					request.getParameter("inputUsername"), request.getParameter("inputPassword"), request.getParameter("inputEmail"), "Manager");
			Service.insertEmployee(cur);
			return "html/mmainpage.html";
		}
		else {
			cur=new Employee(0,request.getParameter("inputFirstName"),request.getParameter("inputLastName"),
					request.getParameter("inputUsername"), request.getParameter("inputPassword"), request.getParameter("inputEmail"), "Employee");
			Service.insertEmployee(cur);
			return "html/emainpage.html";
		}
	}
	
	public static String login(HttpServletRequest request) {
		Employee a =Service.getEmployeeByUsername(request.getParameter("username"));
		if(a!=null) {
			if(a.getPassword().equals(request.getParameter("password"))) {
				cur=a;
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
	
	public static Object getAllMyRequests(HttpServletRequest request) {
		return Service.getRequest(cur.getEmpId());
	}
	public static Object getRequests(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("getId"));
		System.out.println(x);
		System.out.println(Service.getRequest(x));
		return Service.getRequest(x);
	}
	
	public static Object getInfo(HttpServletRequest request) {
		List<Object> lst = new ArrayList<>();
		System.out.println(cur);
		if(cur!=null) {
			lst.add(cur);
		}
		return lst;
	}
	
	public static Object getResolvedRequests(HttpServletRequest request) {
		return Service.getResolvedRequests();
	}
	
	public static Object getUnresolvedRequests(HttpServletRequest request) {
		System.out.println(Service.getUnresolvedRequests());
		return Service.getUnresolvedRequests();
	}
	
	public static Object getAllRequests(HttpServletRequest request) {
		System.out.println(Service.getAllRequests().toString());
		return Service.getAllRequests();
	}
	
	public static Object getAllEmployees(HttpServletRequest request) {
		return Service.getAllEmployees();
	}
	
	public static Object approveRequest(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("aId"));
		System.out.println(x);
		return Service.approveRequest(x);
	}
}
