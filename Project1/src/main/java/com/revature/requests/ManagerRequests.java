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
 * Servlet implementation class ManagerRequests
 */
public class ManagerRequests extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public ManagerRequests()
    {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String decision = request.getParameter("switch");
		String email = request.getParameter("email");
		switch(decision) 
		{ 
		///////////////////Manager Selections/////////////////////////////
		case "ApproveDeny": 
		{	
			int recID = Integer.parseInt(request.getParameter("requestId"));
			String status = (String) request.getParameter("status");
			String username = (String) request.getParameter("manager");
			Reimbursment rec = new Reimbursment();
			rec = ReimbursmentService.getRecord(recID);
			ReimbursmentService.updateStatus(rec, username, status);
			HttpSession session = request.getSession();
			RequestDispatcher rd;
			session.setAttribute("UpdateRec", rec);
			rd = request.getRequestDispatcher("ManagerPage.jsp");
			rd.forward(request, response);
		}
	break;
	case "ViewAllPending":
	{
		List<Reimbursment> users = new ArrayList<>();
		users = ReimbursmentService.getAllPending();
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		session.setAttribute("All Pending", users);
		rd = request.getRequestDispatcher("ManagerPage.jsp");
		rd.forward(request, response);
	}
	break;
	case "ViewAllRecords":
	{

		List<Reimbursment> users = new ArrayList<>();
		users = ReimbursmentService.getAllRecords();
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		session.setAttribute("List All", users);
		rd = request.getRequestDispatcher("ManagerPage.jsp");
		rd.forward(request, response);
	}
	break;
	case "ViewEmployee":
	{
		List<Reimbursment> users = new ArrayList<>();
		users = ReimbursmentService.getAllEmployeeRecords(email);
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		session.setAttribute("All Emplyoee List", users);
		rd = request.getRequestDispatcher("ManagerPage.jsp");
		rd.forward(request, response);
	}
	break;
		
		default: // do nothing
		}
	}
}

