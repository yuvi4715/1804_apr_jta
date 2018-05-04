package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletContextConfig() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
//		ServletContext sc1 = getServletConfig().getServletContext();
//		
//		//another approach to get instance of servlet context
//		//ServletContext sc2 = getServletContext();
//		System.out.println(sc1.getInitParameter("BestQB"));
//		response.getWriter().append(sc1.getInitParameter("BestQB"));
//		
//		System.out.println(sc1.getInitParameter("BestQBAllTime"));
//		response.getWriter().append(sc1.getInitParameter("BestQBAllTime"));
		
		//using servlet context
		response.getWriter().append(getServletContext().getInitParameter("BestQBAllTime"));
		response.getWriter().append(getServletContext().getInitParameter("BestQB"));
		
		//ServletConfig - for init parameter 
		response.getWriter().append(getServletConfig().getInitParameter("BestQBAllTime"));
		
		//ServletConfig - for context parameter
		response.getWriter().append(getServletConfig().getInitParameter("BestQB"));
		
		response.getWriter().append(getServletConfig().getServletContext().getInitParameter("BestQBAllTime"));

		//getParameter vs getInitParameter
		//getInitParameter - used for retrieving information from the web.xml
		//getParameter - used for retrieving information from the user (as part of the request object)
		String s1 = request.getParameter("text1");
		String s2 = request.getParameter("text2");
		
		response.getWriter().append(s1);
		response.getWriter().append(s2);
		
		//getAttribute - used for retrieving information from another servlet
		String s3 = getServletConfig().getInitParameter("BestQB");
		getServletContext().setAttribute("s4", "value for s4");
	}

}
