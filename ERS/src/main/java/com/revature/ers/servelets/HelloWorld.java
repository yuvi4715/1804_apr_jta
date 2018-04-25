package com.revature.ers.servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    
    public HelloWorld() {
        super();
    }

	//public void init(ServletConfig config) throws ServletException {
		
	//}

	//public void destroy() {
		
	//}

	//protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at as a: G E T");
		RequestDispatcher rd = request.getRequestDispatcher("Test.dotoo");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served as a: P O S T");
	}

}
