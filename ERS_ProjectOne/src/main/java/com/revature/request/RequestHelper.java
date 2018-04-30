package com.revature.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.delegate.EmployeeCreateDelegate;
import com.revature.delegate.EmployeeLoginDelegate;
import com.revature.delegate.ManagerDelegate;
import com.revature.delegate.ReimbursementDelegate;
import com.revature.util.LoggingUtil;

/* Class that helps the master servlet with mappings to specific controllers */
public class RequestHelper {
	final static Logger log = Logger.getLogger(LoggingUtil.class);
	
	/*Variables to delegate to controllers*/
	private static EmployeeCreateDelegate createControl = new EmployeeCreateDelegate();
	private static EmployeeLoginDelegate employeeControl = new EmployeeLoginDelegate();
	private static ManagerDelegate managerControl = new ManagerDelegate();
	private static ReimbursementDelegate requestControl = new ReimbursementDelegate();
	
	public static String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Get request*/
		String requestHandled = request.getRequestURI().substring(request.getContextPath().length()+1);
		while(requestHandled.indexOf("/")>0) {
			requestHandled = requestHandled.substring(0, requestHandled.indexOf("/"));
		}
		
		//Changing between controllers
		switch(requestHandled) {
		case "createEmployee.do": 
			createControl.createEmployee(request, response);
			break;
		case "employeeLogin.do":
			employeeControl.employeeLogin(request, response);
			break;
		case "employeeLogout.do":
			employeeControl.employeeLogout(request, response);
			break;
		case "managerLogin.do":
			managerControl.managerLogin(request, response);
			break;
		case "managerLogout.do":
			managerControl.managerLogout(request, response);
			break;
		case "employeePendingRequests.do" :
			requestControl.employeePendingRequests(request, response);
			break;
		case "employeeResolvedRequests.do" :
			requestControl.employeeResolvedRequests(request, response);
			break;
		case "viewEmployee.do" :
			managerControl.viewEmployee(request, response);
			break;
		case "searchEmployee.do" :
			managerControl.searchEmployee(request, response);
			break;
		case "approveRequest.do" :
			managerControl.approveRequest(request, response);
			break;
		case "denyRequest.do" :
			managerControl.denyRequest(request, response);
			break;
		case "myEmployee.do" :
			employeeControl.myEmployee(request, response);
			break;
		case "editEmployee.do" :
			employeeControl.editEmployee(request, response);
			break;
		case "submitRequest.do" :
			requestControl.submitRequest(request, response);
			break;
		case "specificPendingRequests.do" :
			requestControl.specificPendingRequests(request, response);
			break;
		case "specificResolvedRequests.do" :
			requestControl.specificResolvedRequests(request, response);
			break;
		default: 
			break;
		}
		return "404.html";
	}
}