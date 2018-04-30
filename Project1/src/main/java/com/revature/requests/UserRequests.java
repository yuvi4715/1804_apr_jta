package com.revature.requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.model.Reimbursment;
import com.revature.services.ReimbursmentService;

/**
 * Servlet implementation class UserRequests
 */
public class UserRequests extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public UserRequests() 
    {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		String decision = request.getParameter("switch");
		String email = request.getParameter("email");
		switch(decision) 
		{ 
		//////////////Employee Selections////////////////////////////////
		case "New Reimbursement": 
			{
				String username = (String) request.getParameter("user");
				String status = "PENDING";
				double amount =  Double.parseDouble(request.getParameter("amount"));
				String purpose = (String) request.getParameter("purpose");
				Reimbursment rec = new Reimbursment(username,status,0, purpose, amount,purpose,null, null);
				ReimbursmentService.insertRecord(rec);
				HttpSession session = request.getSession();
				RequestDispatcher rd;
				session.setAttribute("newRec", rec);
				rd = request.getRequestDispatcher("EmployeePage.jsp");
				rd.forward(request, response);
			}
		break;
		case "View Pending":
		{
			List<Reimbursment> users = new ArrayList<>();
			users = ReimbursmentService.getAllMyPending(email);
			HttpSession session = request.getSession();
			RequestDispatcher rd;
			session.setAttribute("Pending", users);
			rd = request.getRequestDispatcher("EmployeePage.jsp");
			rd.forward(request, response);
		}
		break;
		case "View Approved":
		{

			List<Reimbursment> users = new ArrayList<>();
			users = ReimbursmentService.getAllMyApproved(email);
			HttpSession session = request.getSession();
			RequestDispatcher rd;
			session.setAttribute("Approved List", users);
			rd = request.getRequestDispatcher("EmployeePage.jsp");
			rd.forward(request, response);
		}
		break;
		case "View All":
		{
			List<Reimbursment> users = new ArrayList<>();
			users = ReimbursmentService.getAllEmployeeRecords(email);
			HttpSession session = request.getSession();
			RequestDispatcher rd;
			session.setAttribute("All List", users);
			rd = request.getRequestDispatcher("EmployeePage.jsp");
			rd.forward(request, response);
		}
		break;
	
		
		default: // do nothing
		}
	}

}
