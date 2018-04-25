package com.ranieri.servlet;

import com.ranieri.login.MainLogin;
import com.ranieri.model.Employee;
import com.ranieri.service.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class FController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
   
    public FController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
	//	Employee test = EmployeeService.getEmployee(email, password);
	//	Employee test = EmployeeService.getEmployee("tester@test.com", "test");
	
		response.getWriter().append("Served at: FController connection "+ request.getParameter("email") +email).append(RequestHelper.process(request));
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
