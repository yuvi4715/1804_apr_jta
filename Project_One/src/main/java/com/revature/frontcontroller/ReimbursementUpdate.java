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
 * Servlet implementation class EntriesUpdate
 */
public class ReimbursementUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// if(request.getSession(false)==null) {
				// response.setStatus(400);
				// return; //If user does not have a session it denies the access
				// }

				String amount = request.getParameter("reimb_amount");
				String purpose = request.getParameter("reimb_purpose");
				String rrequest = request.getParameter("reimb_request");

				if (rrequest == null || purpose == null || amount == null) {
					response.getWriter().println("Insufficient paramenters.");
					return;
				}
				double dAmount = -1;
				try {
					dAmount = Double.parseDouble(amount);
				} catch (NumberFormatException e) {

				}
				if (dAmount < 0) {
					response.getWriter().println("invalid amount");
					return;
				}

				Timestamp requestTimestamp = null;
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
					Date parsedDate = dateFormat.parse(rrequest);
					requestTimestamp = new java.sql.Timestamp(parsedDate.getTime());
				} catch (Exception e) { // this generic but you can control another types of exception
					// look the origin of excption
				}
				if (requestTimestamp == null) {
					response.getWriter().println("Invalid timestamp");
					return;
				}
				System.out.println(dAmount);
				System.out.println(requestTimestamp);
				System.out.println(request.getSession(false).getAttribute("id"));
				
				ExpenseReimbursementService.insert_request(new Reimbursements(0, dAmount, requestTimestamp, new Timestamp(0),
						purpose, (int) request.getSession(false).getAttribute("id"), 0, ("PENDING")));
				response.sendRedirect("./form.html");
				
			}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
