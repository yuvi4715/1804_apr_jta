package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// bridge between view and model
	// receive request to change tables
	// change tables with calls to service methods
	// send update information back to view

	public FrontController() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Woops, used get instead of post");

	}

	// use do post for sensitive information
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String json = RequestHelper.process(request);
		System.out.println("JSON: "+ json);
		Cookie cookie = new Cookie("email", (String) request.getAttribute("email"));
		System.out.println("Cookie value: " + cookie.getValue());
		response.addCookie(cookie);
		
		System.out.println("DO POST");
		try {
			if ((boolean) request.getAttribute("employee")) {
				response.sendRedirect("/expense_reimbursement_service/html/employee.html");
			} else if (!(boolean) request.getAttribute("employee")) {
				response.sendRedirect("/expense_reimbursement_service/html/manager.html");
			}
			if((boolean) request.getAttribute("logout")) {
				response.sendRedirect("/expense_reimbursement_service/html/login.html");
			}

		} catch (NullPointerException npe) {
			System.err.println("NULL POINTER EXCEPION");
		}

		response.getWriter().append(json);// send json to client

	}

}
