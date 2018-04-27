package com.ranieri.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;


public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MasterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: the MASTER SERVLET ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String json = (RequestHelper.process(request));
	
		Cookie cookie = new Cookie("username",(String) request.getAttribute("username"));
		response.addCookie(cookie);

		try {
		if((int)request.getAttribute("manager") == 1) {			
			response.sendRedirect("/reimbursement/html/managerPage.html");		
		}
		if((int)request.getAttribute("manager") == 0) {
			response.sendRedirect("/reimbursement/html/employeePage.html");
		}
		}catch (NullPointerException e){
			System.out.println("This is an okay null exception for now");
		}
		System.out.println(json);

	}

}
