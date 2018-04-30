package com.revature.services;

import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.Reimbursement_Impl;
import com.revature.models.User;

public class LoginService{
	static Reimbursement_Impl r = new Reimbursement_Impl();
	
	final static Logger log = Logger.getLogger(Reimbursement_Impl.class);
	
	public static void userLogin(HttpServletRequest req, HttpServletResponse resp) {
		log.info("User " + req.getParameter("empLog") + " attempted to log in.");
		User user = r.userLogin(req.getParameter("empLog"), req.getParameter("empPass"));
		if(user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			try {
				resp.sendRedirect("html/employeehub.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				resp.sendRedirect("html/login.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void adminLogin(HttpServletRequest req, HttpServletResponse resp) {
		log.info("Administrator " + req.getParameter("admLog") + " attempted to log in.");
		User admin = r.adminLogin(req.getParameter("admLog"), req.getParameter("admPass"));
		if(admin != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", admin);
			try {
				resp.sendRedirect("html/adminhub.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				resp.sendRedirect("html/login.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Boolean new_emp(String fname, String lname, String email, String pw) {
		log.info("Login Service Creating new employee");
		log.info("parameters " + email + " " + pw + " " + fname + " " + lname);
		return r.addUser(fname, lname, email, pw);
	}
	
	public static Boolean new_admin(String fname, String lname, String email, String pw) {
		return r.addAdmin(fname, lname, email, pw);
	}
	
	public static void logout(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.invalidate();
		try {
			resp.sendRedirect("html/login.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
