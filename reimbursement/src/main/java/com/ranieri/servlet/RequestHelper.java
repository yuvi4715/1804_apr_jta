package com.ranieri.servlet;

import javax.servlet.http.HttpServletRequest;

import com.ranieri.model.Employee;
import com.ranieri.service.EmployeeService;

public class RequestHelper {
	
	
	
public static String process(HttpServletRequest req) {
		
		switch (req.getRequestURI()) {
		case "/reimbursement/FController":
			return "how are you doing"+ req.getParameter("email");//"I sucessfully reached the sql database"+EmployeeService.getEmployee(req.getParameter("name"), req.getParameter("psw"));
		default:
				return "unable to reach database";
		
		}
		


}
}