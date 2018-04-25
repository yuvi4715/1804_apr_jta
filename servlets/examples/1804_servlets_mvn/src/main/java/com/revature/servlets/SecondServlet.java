package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("init method - SecondServlet");
    	super.init(config);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet - SecondServlet");
		
		System.out.println(getServletContext().getAttribute("s3"));
		System.out.println(getServletContext().getAttribute("s4"));
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>\r\n" + 
				"<body>\r\n" + 
				"<h2>This text is from second servlet!</h2>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
	}

}
