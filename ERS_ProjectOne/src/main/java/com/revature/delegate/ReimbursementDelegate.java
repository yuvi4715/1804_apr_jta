package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoJdbc;
import com.revature.model.Request;
import com.revature.util.LoggingUtil;

public class ReimbursementDelegate {
	
	public RequestDao rd = new RequestDaoJdbc();
	final static Logger log = Logger.getLogger(LoggingUtil.class);
	
	public void submitRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		float requestAmount = Float.parseFloat(request.getParameter("requestAmount"));
		String purpose = request.getParameter("purpose");
		String status = "pending";
		String reviewedBy = null;
		String reviewedDate = null;
	    String requestDate = null; 
		Request newRequest = new Request(0, requestAmount, EmployeeLoginDelegate.userSession, reviewedBy, status, purpose, requestDate, reviewedDate);
		rd.insertRequest(newRequest);
		PrintWriter pw = response.getWriter();
		pw.println("You have successfully submitted a new reimbursement request!");
		pw.println("Please wait for a manager to look over it...");
		log.info("A new request has been created by: " + EmployeeLoginDelegate.userSession);
	}
	
	public void employeePendingRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List <Request> pendingRequests = new ArrayList<>();
		pendingRequests = rd.getAllPendingRequest();
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
	    pw.println("<table><tr>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Request ID</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Request Amount</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Purpose</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Status</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Requester</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Reviewed By</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Request Date</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Review Date</th></tr>");
	
	for (int i = 0; i<pendingRequests.size(); i++) {
		Request Current = pendingRequests.get(i);
		pw.println("<tr>"
				+ " <td style=\"color:rgb(255,255,255)\">" + Current.getRequestID() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getRequestAmount() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getPurpose() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getStatus() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getRequester()+ "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getReviewedBy()+ "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getRequestDate()+ "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getReviewDate() + "</td></tr>");
	}
		pw.println("</table>");
	}

	
	public void employeeResolvedRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List <Request> resolvedRequests = new ArrayList<>();
		resolvedRequests = rd.getAllResolvedRequest();
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
	    pw.println("<table><tr>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Request ID</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Request Amount</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Purpose</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Status</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Requester</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Reviewed By</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Request Date</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Review Date</th></tr>");
	
	for (int i = 0; i<resolvedRequests.size(); i++) {
		Request Current = resolvedRequests.get(i);
		pw.println("<tr>"
				+ " <td style=\"color:rgb(255,255,255)\">" + Current.getRequestID() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getRequestAmount() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getPurpose() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getStatus() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getRequester()+ "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getReviewedBy()+ "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getRequestDate()+ "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getReviewDate() + "</td></tr>");
	}
		pw.println("</table>");
	}
	
	public void specificPendingRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List <Request> pendingRequests = new ArrayList<>();
		pendingRequests = rd.getAllPendingRequest(EmployeeLoginDelegate.userSession);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
	    pw.println("<table><tr>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Request ID</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Request Amount</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Purpose</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Status</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Requester</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Reviewed By</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Request Date</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Review Date</th></tr>");
	
	for (int i = 0; i<pendingRequests.size(); i++) {
		Request Current = pendingRequests.get(i);
		pw.println("<tr>"
				+ " <td style=\"color:rgb(255,255,255)\">" + Current.getRequestID() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getRequestAmount() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getPurpose() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getStatus() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getRequester()+ "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getReviewedBy()+ "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getRequestDate()+ "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getReviewDate() + "</td></tr>");
	}
		pw.println("</table>");
	}
	
	public void specificResolvedRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List <Request> resolvedRequests = new ArrayList<>();
		resolvedRequests = rd.getAllResolvedRequest(EmployeeLoginDelegate.userSession);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
	    pw.println("<table><tr>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Request ID</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Request Amount</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Purpose</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Status</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Requester</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Reviewed By</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Request Date</th>");
		pw.println("<th style=\"color:rgb(0,255,255)\">Review Date</th></tr>");
	
	for (int i = 0; i<resolvedRequests.size(); i++) {
		Request Current = resolvedRequests.get(i);
		pw.println("<tr>"
				+ " <td style=\"color:rgb(255,255,255)\">" + Current.getRequestID() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getRequestAmount() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getPurpose() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getStatus() + "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getRequester()+ "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getReviewedBy()+ "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getRequestDate()+ "</td>");
		pw.println("<td style=\"color:rgb(255,255,255)\">" + Current.getReviewDate() + "</td></tr>");
	}
		pw.println("</table>");
	}
}
