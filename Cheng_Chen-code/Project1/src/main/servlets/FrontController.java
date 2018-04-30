package main.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		String str = request.getRequestURI();
		response.setContentType("application/json");
		
		if (str.equals("/Project1/login.do") || str.equals("/Project1/msubmitRequest.do") || str.equals("/Project1/esubmitRequest.do") || str.equals("/Project1/resolveRequest.do")) 
		{
			response.sendRedirect(RequestHelper.process(request));
		} 
		else 
		{
			ObjectMapper map = new ObjectMapper();
			map.writeValue(pw, RequestHelper.oprocess(request));
		}
		pw.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println(request.getReader().readLine());
		PrintWriter pw = response.getWriter();
		String str = request.getRequestURI();
		response.setContentType("application/json");
		
		System.out.println(str);
		
		if(str.equals("/Project1/login.do") || str.equals("/Project1/msubmitRequest.do") || str.equals("/Project1/esubmitRequest.do") || str.equals("/Project1/resolveRequest.do")) 
		{
			response.sendRedirect(RequestHelper.process(request));
		}
		else 
		{
			ObjectMapper map = new ObjectMapper();
			map.writeValue(pw, RequestHelper.oprocess(request));
		}
		pw.flush();
	}

}