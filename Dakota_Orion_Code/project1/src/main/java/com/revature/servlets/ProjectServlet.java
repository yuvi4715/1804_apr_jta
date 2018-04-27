package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ProjectServlet
 */
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("doInit");
	}


	public void destroy() {
		System.out.println("doDestroy");
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doService");
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*System.out.println("doGet");
		RequestDispatcher rd = request.getRequestDispatcher("SecondServlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        String s1 = request.getParameter("username");
        String s2 = request.getParameter("password");
        pw.print("<html><body><div>" + s1 + " : " + s2 + ", are the values entered" +"<html><body><div>");
        rd.include(request, response);
        pw.close();*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		String str = request.getRequestURI();
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		if(str.equals("/project1/login.do")||str.equals("/project1/signup.do")) {
			response.sendRedirect(RequestHelper.process(request));
		}
		else {
			ObjectMapper map = new ObjectMapper();
			map.writeValue(pw, RequestHelper.oprocess(request));
		}
		pw.flush();
	}

}
