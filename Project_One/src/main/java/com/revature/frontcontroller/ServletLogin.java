package com.revature.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Users;
import com.revature.service.ExpenseReimbursementService;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Users login = new Users(0, null, password, null, null, email, 0);
		login = ExpenseReimbursementService.getUser(login);
		System.out.println(login);		
		
		if (login != null) {
			
			HttpSession session = request.getSession();
			
			if (session.isNew()) {
				session.setAttribute("email", email);
				session.setAttribute("IsManager", login.getIsManager());
				session.setAttribute("id", login.getUsers_id());
			}
		
			Cookie isAdmin = new Cookie("isAdmin", login.getIsManager()+"");
			Cookie emailCookie = new Cookie("email", email);
			Cookie nameCookie = new Cookie("name", login.getFirst_name());

			
			response.addCookie(isAdmin);
			response.addCookie(emailCookie);
			response.addCookie(nameCookie);
			
			if(login.getIsManager() > 0)
			response.sendRedirect("./tableManager.html");
			
			else 
				response.sendRedirect("./table.html");

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
