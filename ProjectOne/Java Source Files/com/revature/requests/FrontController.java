package com.revature.requests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
        
    }

	
//	public void init(ServletConfig config) throws ServletException {
//		
//	}
//
//	
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		super.service(request, response);
//	}
    Object User;
  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(true);
//		if (session.isNew()) {
//			session.setAttribute("email", request.getParameter("email"));
//		}else {
//			session.getAttribute("email");
//		}
//		
//		System.out.println(session.getAttribute("username"));
//		System.out.println(session.getAttribute("password"));
//			
		
		ObjectMapper objMapper = new ObjectMapper();
		Object obj = RequestHelper.process(request);
		PrintWriter pw = response.getWriter();
		if (obj != null) {
			System.out.println(obj.toString());
			System.out.println();
			String objString = objMapper.writeValueAsString(obj);
			System.out.println(objString);
			System.out.println("appending to response");
			response.setContentType("application/json");
			pw.write(objString);
			System.out.println("appended");

			
		} else {
			response.setContentType("html/text");
			pw.write("null");
//			session.invalidate();
		}
		
		//if request.getRequestURI() == "";
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	
			doGet(request, response);
		
	}
	
	

}
