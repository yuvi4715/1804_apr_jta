package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;
import com.revature.service.ReimbursementService;

public class ReimbursementController {

	public static String submit(HttpServletRequest request) {
		
		
		request.setAttribute("redirectFlag", new Integer(1));
		
		
		String purp = request.getParameter("requestPurpose");
		String img = request.getParameter("requestImage");
		String ammountStr = request.getParameter("requestAmmount");
		Integer empID = (Integer) request.getSession().getAttribute("userid");
		
		//int id = Integer.parseInt(idStr);
		double ammount = Double.parseDouble(ammountStr);
		
		Reimbursement reim = new Reimbursement(empID, purp, img, ammount);
		
		ReimbursementService.insert(reim);
		
		
		return "html/employeeMenu.html";
	}
	
	public static String approve(HttpServletRequest request) {
		//TODO
		request.setAttribute("redirectFlag", new Integer(1));
		
		Integer reimNum = Integer.parseInt(request.getParameter("reqid"));
		Integer revNum = (Integer) request.getSession().getAttribute("userid");
		
		Reimbursement reim = ReimbursementService.get(reimNum);
		
		reim.setStatus(1);
		reim.setReviewerid(revNum);
		
		ReimbursementService.update(reim);
		
		
		return "html/requestView.html";
	}
	
	public static String deny(HttpServletRequest request) {
		//TODO
			request.setAttribute("redirectFlag", new Integer(1));
				
		Integer reimNum = Integer.parseInt(request.getParameter("reqid"));
		Integer revNum = (Integer) request.getSession().getAttribute("userid");
				
		Reimbursement reim = ReimbursementService.get(reimNum);
		reim.setStatus(2);
		reim.setReviewerid(revNum);
			
		ReimbursementService.update(reim);
				
				
		return "html/requestView.html";
	}
	
	public static String displayAll(HttpServletRequest request) {
		request.setAttribute("redirectFlag", new Integer(0));
		
		
		StringBuilder strBldr = new StringBuilder("");
		
		List<Reimbursement> reimList = ReimbursementService.getAll();
		
		
		for(Reimbursement reim : reimList) {
			strBldr.append("<tr><td>" + reim.getReqid() + "</td><td>" + reim.getRequester().getlName() + ", " 
							+ reim.getRequester().getfName() + "</td><td>" + reim.getAmmount() + "</td><td>"  
							+ reim.getPurpose() +"</td><td>" + reim.getReqDate() + "</td><td>" + reim.getStatusStr() + "</td></tr>");	
		}
		
		String str = strBldr.toString();
		
		return str;

	}
	
	public static String displayPending(HttpServletRequest request) {
		//TODO
		request.setAttribute("redirectFlag", new Integer(0));
		
		
		StringBuilder strBldr = new StringBuilder("");
		
		
		List<Reimbursement> reimList = ReimbursementService.getBy("status", 0);
		
		
		for(Reimbursement reim : reimList) {
			strBldr.append("<tr><td>" + reim.getReqid() + "</td><td>" + reim.getRequester().getlName() + ", " 
							+ reim.getRequester().getfName() + "</td><td>" + reim.getAmmount() + "</td><td>"  
							+ reim.getPurpose() +"</td><td>" + reim.getReqDate() + "</td><td>" + reim.getStatusStr() + "</td></tr>");	
		}
		
		String str = strBldr.toString();
		
		return str;	
	}
	
	public static String displayApproved(HttpServletRequest request) {
		//TODO
		request.setAttribute("redirectFlag", new Integer(0));
		
		
		StringBuilder strBldr = new StringBuilder("");
		
		
		List<Reimbursement> reimList = ReimbursementService.getBy("status", 1);
		
		
		for(Reimbursement reim : reimList) {
			strBldr.append("<tr><td>" + reim.getReqid() + "</td><td>" + reim.getRequester().getlName() + ", " 
							+ reim.getRequester().getfName() + "</td><td>" + reim.getAmmount() + "</td><td>"  
							+ reim.getPurpose() +"</td><td>" + reim.getReqDate() + "</td><td>" + reim.getStatusStr() + "</td></tr>");	
		}
		
		String str = strBldr.toString();
		
		return str;	
	}
	
	public static String displayDenied(HttpServletRequest request) {
		//TODO
		request.setAttribute("redirectFlag", new Integer(0));
		
		
		StringBuilder strBldr = new StringBuilder("");
		
		
		List<Reimbursement> reimList = ReimbursementService.getBy("status", 2);
		
		
		for(Reimbursement reim : reimList) {
			strBldr.append("<tr><td>" + reim.getReqid() + "</td><td>" + reim.getRequester().getlName() + ", " 
							+ reim.getRequester().getfName() + "</td><td>" + reim.getAmmount() + "</td><td>"  
							+ reim.getPurpose() +"</td><td>" + reim.getReqDate() + "</td><td>" + reim.getStatusStr() + "</td></tr>");	
		}
		
		String str = strBldr.toString();
		
		return str;	
	}
	
	public static String displayMine(HttpServletRequest request) {
		request.setAttribute("redirectFlag", new Integer(0));
		
		
		StringBuilder strBldr = new StringBuilder("");
		Integer user = (Integer) request.getSession().getAttribute("userid");
		
		String userStr = user.toString();
		
		List<Reimbursement> reimList = ReimbursementService.getBy("status", userStr);
		
		
		for(Reimbursement reim : reimList) {
			strBldr.append("<tr><td>" + reim.getReqid() + "</td><td>" + reim.getRequester().getlName() + ", " 
							+ reim.getRequester().getfName() + "</td><td>" + reim.getAmmount() + "</td><td>"  
							+ reim.getPurpose() +"</td><td>" + reim.getReqDate() + "</td><td>" + reim.getStatusStr() + "</td></tr>");	
		}
		
		String str = strBldr.toString();
		
		return str;	
		
		
		
	}
}
