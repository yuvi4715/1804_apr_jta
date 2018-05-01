package com.system.servlet;

import java.io.IOException
;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;



/**
 * Servlet implementation class SystemServlet
 */
public class SystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       final static Logger logger = Logger.getLogger(SystemServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	request.setAttribute("username", request.getParameter("username"));
	request.setAttribute("password", request.getParameter("password"));
	request.setAttribute("role", request.getParameter("role"));
	System.out.println(request.getParameter("role") + " "+ request.getAttribute("role"));
	request.setAttribute("reqdetails", request.getParameter("reqdetails"));
	request.setAttribute("reqamount", request.getParameter("reqamount"));
	request.setAttribute("status", request.getParameter("status"));
	System.out.println(request.getParameter("requestid"));
	request.setAttribute("requestid", request.getParameter("requestid"));
		//response.getWriter().append(request.getRequestURI());
		HttpSession session = request.getSession();
	
		
		try{
		
	JSONArray res = RequestHelper.process(request);
	 System.out.println(res);
	// System.out.println(res.length());
	 if(request.getRequestURI().equals( "/reimbursement_system/login.do") && res.length() > 0)
		{
			JSONObject t = res.getJSONObject(0);
			logger.info("setting session");
			session.setAttribute("username", t.get("username"));
			session.setAttribute("role", t.get("role"));
			session.setAttribute("userid", t.get("ID"));
			
			System.out.println("here");
			//response.sendRedirect("/reimbursement_system/html/homepage.html");
			response.getWriter().append(String.valueOf(res));
			System.out.println(response.toString());
			//doGet(request, response);
		}
	}
	catch(NullPointerException e)
	{ 	System.out.println("not in the database");
		logger.error("not in the database");
		response.getWriter().append("");
		//doGet(request, response);
	
	}
					
				
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
//		request.setAttribute("username", request.getParameter("username"));
//		request.setAttribute("password", request.getParameter("password"));
//		response.getWriter().append(request.getRequestURI());
//		HttpSession session = request.getSession();
//		
//		
//		try{
//		
//	JSONArray res = RequestHelper.process(request);
//	 System.out.println(res);
//	 System.out.println(res.length());
//	 if(request.getRequestURI().equals( "/reimbursement_system/login.do") && res.length() > 0)
//		{
//			JSONObject t = res.getJSONObject(0);
//			session.setAttribute("username", t.get("username"));
//			session.setAttribute("role", t.get("role"));
//			response.getWriter().append(String.valueOf(res));
//			System.out.println("here");
//			//response.sendRedirect("/reimbursement_system/html/homepage.html");
//			doGet(request, response);
//		}
//	}
//	catch(NullPointerException e)
//	{ 	System.out.println("not in the database");
//		response.getWriter().append("username or password is not in the database");
//		doGet(request, response);
//	
//	}
//					
//				
//		
//	}
	}

}
