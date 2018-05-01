package main.servlets;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import main.Model.Employee;
import main.Model.Manager;
import main.Model.Reimbursement;
import main.Service.ReimbursementService;

public class RequestHelper
{
	static Employee currentEmp;
	static Manager currentMan;
	public static String process(HttpServletRequest request) 
	{
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) 
		{
			case "/Project1/login.do":
				System.out.println("login");
				return login(request);
				
			case "/Project1/msubmitRequest.do":
				System.out.println("manager submitting request");
				return msubmitRequest(request);
				
			case "/Project1/esubmitRequest.do":
				System.out.println("employee submitting request");
				return esubmitRequest(request);
				
			case "/Project1/resolveRequest.do":
				System.out.println("resolving request");
				return resolveRequest(request);
				
			default:
				System.out.println("default");
				return "404.jsp";
		}
	}
	
	public static Object oprocess(HttpServletRequest request) 
	{
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) 
		{
		
			case "/Project1/html/getAllEmployees.do":
				System.out.println("getting all Employees");
				return getAllEmployees(request);
				
			case "/Project1/html/getAllRequests.do":
				System.out.println("getting all Requests");
				return getAllRequests(request);
				
			case "/Project1/html/getResolvedRequests.do":
				System.out.println("getResolvedRequests");
				return getResolvedRequests(request);
				
			case "/Project1/html/getUnresolvedRequests.do":
				System.out.println("getPendingRequests");
				return getPendingRequests(request);
				
			case "/Project1/html/getRequestsFor.do":
				System.out.println("getRequests");
				return getRequestsFor(request);
							
			case "/Project1/html/getInfo.do":
				System.out.println("getInfo");
				return getInfo(request);
				
			case "/Project1/html/getAllMyRequests.do":
				System.out.println("get all my requests");
				return getAllMyRequests(request);
				
			default:
				System.out.println("default");
				return "404.jsp";
		}
	}
	
	public static String msubmitRequest(HttpServletRequest request) 
	{
		ReimbursementService.insertReimbursement(new Reimbursement(Double.parseDouble(request.getParameter("amount")), currentMan.getEmail(), request.getParameter("purpose")));
		return "html/ManagerMain.html";
	}
	
	public static String esubmitRequest(HttpServletRequest request) 
	{
		ReimbursementService.insertReimbursement(new Reimbursement(Double.parseDouble(request.getParameter("amount")), currentEmp.getEmail(), request.getParameter("purpose")));
		return "html/EmployeeMain.html";
	}
	
	public static String login(HttpServletRequest request) 
	{
		if(request.getParameter("employeetype").equals("employee"))
		{
			Employee a = ReimbursementService.getEmployee(request.getParameter("email"));
			if(a != null) 
			{
				if(a.getPassword().equals(request.getParameter("psw"))) 
				{
					currentEmp = a;
					return "html/EmployeeMain.html";
				}
				else 
				{
					return "html/index.jsp";
				}
			}
			else 
			{
				return "html/index.jsp";
			}
		}
		else
		{
			Manager b = ReimbursementService.getManager(request.getParameter("email"));
			if(b != null)
			{
				if(b.getPassword().equals(request.getParameter("psw")))
				{
					currentMan = b;
					return "html/ManagerMain.html";
				}
				else
				{
					return "html/index.jsp";
				}
			}
			else
			{
				return "html/index.jsp";
			}
		}
	}
	
	public static Object getAllMyRequests(HttpServletRequest request) 
	{
		return ReimbursementService.getAllForE(currentEmp);
	}
	
	public static Object getRequestsFor(HttpServletRequest request) 
	{
		String emp = request.getParameter("email");
		Employee temp = ReimbursementService.getEmployee(emp);
		return ReimbursementService.getAllForE(temp);
	}


	public static Object getInfo(HttpServletRequest request) 
	{
		List<Employee> self = new ArrayList<>();
		self.add(currentEmp);
		return self;
	}
	
	public static Object getResolvedRequests(HttpServletRequest request) 
	{
		return ReimbursementService.getAllResolved();
	}
	
	public static Object getPendingRequests(HttpServletRequest request) 
	{
		return ReimbursementService.getAllPending();
	}
	
	public static Object getAllRequests(HttpServletRequest request) 
	{
		return ReimbursementService.getAllReimbursements();
	}
	
	public static Object getAllEmployees(HttpServletRequest request) 
	{
		return ReimbursementService.getAllEmployees();
	}
	
	public static String resolveRequest(HttpServletRequest request) 
	{
		int x = Integer.parseInt(request.getParameter("requestID"));
		Reimbursement old = ReimbursementService.getReimbursement(x);
		old.setStatus(request.getParameter("status")); 
		old.setApprovedDate(new Date(System.currentTimeMillis()));
		old.setManager(currentMan.getEmail());
		
		ReimbursementService.updateReimbursement(old);
		
		return "html/ManagerMain.html";
	}
}