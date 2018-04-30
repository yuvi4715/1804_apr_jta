package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.Log;

/**
 * Servlet implementation class servlet
 */
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      String page;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getRequestURI());
		response.setContentType("text/html"); 
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session=request.getSession(false);
		if(session ==null)
		{
			session = request.getSession(true);
			session.setAttribute("user", request.getParameter("username"));
			session.setAttribute("password", request.getParameter("password"));
		}
		//String togo=redirectController.redirecting(request, session);
		Cookie cookie =new Cookie("user", (String) session.getAttribute("user"));
		Cookie cookie2=new Cookie("password", (String) session.getAttribute("password"));
		response.addCookie(cookie);
		String sessionId= session.getId();
		//System.out.println(request.getParameter("reid").toString());
		String result = mapper.writeValueAsString(RequestHelper.process(request));
		response.getWriter().append(result);
		//response.getWriter().append("Session ID: "+sessionId);
		//System.out.println(result);
		
		
		if(result.equals("No session in track, redirecting"))
		{
			response.sendRedirect("/ers/html/home.html");
		}
		
		/*response.getWriter().append(
				session.getAttribute("user").toString()+
				session.getAttribute("UID").toString());*/
		
		
		
		//response.getWriter().write(result);
	    //request.getRequestDispatcher(RequestHelper.process(request).toString()).forward(request, response);
	   // response.sendRedirect("/ers/html/user.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void dispatch(HttpServletRequest request, HttpServletResponse response,String page) 
			throws  javax.servlet.ServletException, java.io.IOException 
	{
		    RequestDispatcher dispatcher = 
		      getServletContext().getRequestDispatcher(page);
		    dispatcher.forward(request, response);
	}

}
