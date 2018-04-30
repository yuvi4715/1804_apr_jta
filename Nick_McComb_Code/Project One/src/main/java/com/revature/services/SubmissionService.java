package com.revature.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.dao.Reimbursement_Impl;
import com.revature.models.User;

public class SubmissionService {
	final static Logger log = Logger.getLogger(Reimbursement_Impl.class);
	static Reimbursement_Impl r = new Reimbursement_Impl();

	public static boolean submitRequest(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession s = req.getSession(false);
		User u = null;
		if(s != null) {
			u = (User) s.getAttribute("user");
		}
		log.info("Employee " + u.getEmail() + " attempted to submit new request.");
		
		if(u != null) {
			try {
				resp.sendRedirect("html/employeehub.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return r.addRequest(Double.parseDouble(req.getParameter("sum")), u.getId(), req.getParameter("reason"));
		}
		return false;
	}
}
