package com.revature.frontcontroller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServlet
 */
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------- new request ---------");
		System.out.println("- Headers -");
		Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
        	String key = (String) headerNames.nextElement();
        	System.out.println(key+" "+request.getHeader(key));
        }
        System.out.println("- Parameters -");
		Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
        	String key = (String)paramNames.nextElement();
        	System.out.println(key+" "+request.getParameter(key));
        }
        System.out.println("- Attributes -");
		Enumeration attribNames = request.getAttributeNames();
        while (attribNames.hasMoreElements()) {
        	String key = (String)attribNames.nextElement();
        	System.out.println(key+" "+request.getAttribute(key));
        }
		
        if (request.getParameter("command")!=null&&request.getParameter("command").equalsIgnoreCase("login"))
        	getServletContext().getRequestDispatcher("/ServletLogin").forward(request, response);;
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
