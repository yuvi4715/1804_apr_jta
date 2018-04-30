package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
    public FrontController() {
        super();
        
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		HttpSession mySession = request.getSession();
		ObjectMapper oMapper = new ObjectMapper();
		PrintWriter printWriter = response.getWriter();
		if (uri.contains("/ersProject1/html/login.do") || uri.contains("/ersProject1/html/SignUp.do")) {
			response.sendRedirect(RequestHelper.processString(request));
		}else {
			oMapper.writeValue(printWriter,RequestHelper.processRequestObject(request));
		}
		printWriter.flush();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getReader().readLine());
		String uri = request.getRequestURI();
		HttpSession mySession = request.getSession();
		ObjectMapper oMapper = new ObjectMapper();
		System.out.println("doPost");
		PrintWriter printWriter = response.getWriter();
		if (uri.contains("/ersProject1/html/login.do") || uri.contains("/ersProject1/html/SignUp.do")) {
			response.sendRedirect(RequestHelper.processString(request));
		}else {
			oMapper.writeValue(printWriter,RequestHelper.processRequestObject(request));
		}
		printWriter.flush();
	}

}
