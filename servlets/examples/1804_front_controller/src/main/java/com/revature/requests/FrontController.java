package com.revature.requests;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	response.setContentType("application/json");
    	String u = request.getParameter("user");
    	//request.getRequestDispatcher(String.valueOf(RequestHelper.process(request))).forward(request, response);
    	response.getWriter().append(String.valueOf(RequestHelper.process(request)));
    	//response.getWriter().append(u);
	}
}
