package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThirdServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("init method - ThirdServlet");
    	super.init(config);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet - ThirdServlet");
		PrintWriter pw = response.getWriter();
		pw.println("<html>\r\n" + 
				"<body>\r\n" + 
				"<h2> Hello from third servlet!</h2>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
		//RequestDispatcher rd = request.getRequestDispatcher("welcome1.html");
		//rd.forward(request, response);
		//rd.include(request, response);
		//response.sendRedirect("SecondServlet");
		response.sendRedirect("welcome1.html");
	}


}
