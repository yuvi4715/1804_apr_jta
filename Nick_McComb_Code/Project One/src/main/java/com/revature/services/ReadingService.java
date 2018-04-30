package com.revature.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.dao.Reimbursement_Impl;
import com.revature.models.Request;
import com.revature.models.User;

public class ReadingService {
	static Reimbursement_Impl r = new Reimbursement_Impl();
	final static Logger log = Logger.getLogger(Reimbursement_Impl.class);
	
	public static List<String> getPendingRequests(HttpServletRequest req, HttpServletResponse resp){
		HttpSession s = req.getSession(false);
		User u = null;
		if(s != null) {
			u = (User) s.getAttribute("user");
		}
		log.info("Getting requests for user " + u.getEmail() + " ID " + u.getId());
		if(u != null) {
			List<Request> requests = r.getMyPendingRequests(u.getId());
			List<String> tor = new ArrayList<>(requests.size());

			try {
				PrintWriter pw = resp.getWriter();
				pw.println("<table>");
				for(Request r : requests) {
//					tor.add(r.toString());
					pw.println("<tr>");
					pw.println("<td>" + r.getAmount() + " | </td>");
					pw.println("<td>" + r.getHandler() + " | </td>");
					pw.println("<td>" + r.getStatus() + " | </td>");
					pw.println("<td>" + r.getPurpose() + " | </td>");
					pw.println("<td>" + r.getComment() + " | </td>");
				}
				pw.println("</table>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return tor;
		}
		return null;
	}
	
	public static List<String> getResolvedRequests(HttpServletRequest req, HttpServletResponse resp){
		HttpSession s = req.getSession(false);
		User u = null;
		if(s != null) {
			u = (User) s.getAttribute("user");
		}
		log.info("Getting requests for user " + u.getEmail());
		if(u != null) {
			List<Request> requests = r.getMyResolvedRequests(u.getId());
			List<String> tor = new ArrayList<>(requests.size());

			try {
				PrintWriter pw = resp.getWriter();
				pw.println("<table>");
				for(Request r : requests) {
//					tor.add(r.toString());
					pw.println("<tr>");
					pw.println("<td>" + r.getAmount() + " | </td>");
					pw.println("<td>" + r.getHandler() + " | </td>");
					pw.println("<td>" + r.getStatus() + " | </td>");
					pw.println("<td>" + r.getPurpose() + " | </td>");
					pw.println("<td>" + r.getComment() + " | </td>");
				}
				pw.println("</table>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return tor;
		}
		return null;
	}
}
