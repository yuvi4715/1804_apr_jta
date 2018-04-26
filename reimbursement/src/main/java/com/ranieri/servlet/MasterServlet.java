package com.ranieri.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		response.getWriter().append("Served at Master Servlet: "+ request.getAttribute("manager") ).append(json);
		
		if((int)request.getAttribute("manager")   ==1) {			
			response.sendRedirect("/reimbursement/html/managerPage.html");
			
		}else {
			response.sendRedirect("/reimbursement/html/employeePage.html");
		}
		
		System.out.println(json+ " this is after the print writer");
		response.flushBuffer();
		
	}

}
