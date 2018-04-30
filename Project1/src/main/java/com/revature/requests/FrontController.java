package com.revature.requests;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.model.Employee;
import com.revature.services.EmployeeService;



/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
    public FrontController()
    {
        super();
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("From Front Controller ");
		String username = (String) request.getParameter("user");
		String password = (String) request.getParameter("pass");
		Employee em = new Employee();
		em = EmployeeService.getEmployee(username);
		String destination = "";
		String tag = "";
		if(em.getIs_manager()==0)
		{
			destination = "EmployeePage.jsp";
			tag = "LoggedInEmployee";
		}else
		{
			destination = "ManagerPage.jsp";
			tag = "LoggedInManager";
		}
		
		
		if( em.getEmail().equals(username) && em.getPassword().equals(password))
		{
				HttpSession session = request.getSession();
				RequestDispatcher rd;
				session.setAttribute(tag, em);
				rd = request.getRequestDispatcher(destination);
				rd.forward(request, response);
				return;
		}
	}
}
