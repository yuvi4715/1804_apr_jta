package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	}


	public void destroy() {
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getRequestURI().equals("/project1/logout.do")) {
			session.setAttribute("curUser", null);
		}
		PrintWriter pw = response.getWriter();
		String str = request.getRequestURI();
		response.setContentType("application/json");
		if(str.equals("/project1/login.do")||str.equals("/project1/signup.do")||str.equals("/project1/msubmitRequest.do")||str.equals("/project1/esubmitRequest.do")) {
			response.sendRedirect(RequestHelper.process(request,session));
		}
		else {
			ObjectMapper map = new ObjectMapper();
			map.writeValue(pw, RequestHelper.oprocess(request,session));
		}
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getRequestURI().equals("/project1/logout.do")) {
			session.setAttribute("curUser", null);
			System.out.println("session= " + session.getAttribute("curUser").toString());
		}
		System.out.println(request.getReader().readLine());
		PrintWriter pw = response.getWriter();
		String str = request.getRequestURI();
		response.setContentType("application/json");
		if(str.equals("/project1/login.do")||str.equals("/project1/signup.do")||str.equals("/project1/msubmitRequest.do")||str.equals("/project1/esubmitRequest.do")) {
			response.sendRedirect(RequestHelper.process(request,session));
		}
		else {
			ObjectMapper map = new ObjectMapper();
			map.writeValue(pw, RequestHelper.oprocess(request,session));
		}
		pw.flush();
	}

}
