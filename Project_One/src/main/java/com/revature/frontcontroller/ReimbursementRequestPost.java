package com.revature.frontcontroller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Reimbursements;
import com.revature.service.ExpenseReimbursementService;

/**
 * Servlet implementation class ReimbursementRequestPost
 */
public class ReimbursementRequestPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReimbursementRequestPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// if(request.getSession(false)==null) {
		// response.setStatus(400);
		// return; //If user does not have a session it denies the access
		// }

		
		String status = request.getParameter("reimb_status");
		String rID = request.getParameter("reimb_id");
		if(status == null||rID==null) {
			response.getWriter().println("Insuficient parameters");
			return;
		} else if(status.length()>10) {
			response.getWriter().println("Satus must be less than 10 characters");
			return;
		}
		int rIDINT = -1;
		try {
			rIDINT = Integer.parseInt(rID);
		} catch (NumberFormatException e) {

		}
		if (rIDINT < 0) {
			response.getWriter().println("invalid rid");
			return;
		}
		System.out.println(request.getSession(false).getAttribute("id"));
		
		ExpenseReimbursementService.man_update_requests(new Reimbursements(rIDINT, 0, null, null,
				null, 0, (int) request.getSession(false).getAttribute("id"), status));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
